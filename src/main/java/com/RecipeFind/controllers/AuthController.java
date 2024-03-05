package com.RecipeFind.controllers;

import com.RecipeFind.models.User;
import com.RecipeFind.models.dto.UserDTO;
import com.RecipeFind.models.dto.builders.UserDTOBuilder;
import com.RecipeFind.models.dto.request.LoginRequest;
import com.RecipeFind.models.dto.request.SignupRequest;
import com.RecipeFind.models.dto.response.JwtResponse;
import com.RecipeFind.services.AuthService;
import com.RecipeFind.services.UserService;
import com.RecipeFind.services.validation.utils.ValidatorException;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            User user = authService.registerUser(signUpRequest);
            return ResponseEntity.ok(UserDTOBuilder.toUserDTO(user));
        } catch (ValidatorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok().body(authService.signIn(loginRequest));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad credentials", e);
        }
    }

    @PostMapping("/sign-out")
    public ResponseEntity<?> logoutUser() {
        return authService.signOut();
    }
}
