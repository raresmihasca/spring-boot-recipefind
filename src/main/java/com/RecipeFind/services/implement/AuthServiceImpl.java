package com.RecipeFind.services.implement;

import com.RecipeFind.models.RefreshToken;
import com.RecipeFind.models.User;
import com.RecipeFind.models.dto.builders.AuthenticationDTOBuilder;
import com.RecipeFind.models.dto.request.LoginRequest;
import com.RecipeFind.models.dto.request.SignupRequest;
import com.RecipeFind.models.dto.response.JwtResponse;
import com.RecipeFind.repositories.UserRepository;
import com.RecipeFind.services.AuthService;
import com.RecipeFind.services.jwt.JwtUtils;
import com.RecipeFind.services.validation.RegisterAccountValidator;
import com.RecipeFind.services.validation.utils.ValidatorException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    @Autowired
    private RegisterAccountValidator registerAccountValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public User registerUser(SignupRequest signUpRequest) throws ValidatorException {
        registerAccountValidator.validate(signUpRequest);
        if (Boolean.TRUE.equals(userRepository.existsByEmail(signUpRequest.getEmail()))) {
            throw new ValidatorException("Account already exists");
        }

        User user = AuthenticationDTOBuilder.fromSignupRequest(signUpRequest);
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);

        return userRepository.save(user);
    }

    @Override
    public JwtResponse signIn(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwtToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

        return new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
                userDetails.getEmail(), roles);
    }

    @Override
    public ResponseEntity<?> signOut() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return ResponseEntity.ok(userId);

    }
}
