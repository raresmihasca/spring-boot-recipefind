package com.RecipeFind.services;


import com.RecipeFind.models.User;
import com.RecipeFind.models.dto.request.LoginRequest;
import com.RecipeFind.models.dto.request.SignupRequest;
import com.RecipeFind.models.dto.response.JwtResponse;
import com.RecipeFind.services.validation.utils.ValidatorException;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    User registerUser(SignupRequest signUpRequest) throws ValidatorException;

    JwtResponse signIn(LoginRequest loginRequest);

    ResponseEntity<?> signOut();

}
