package com.RecipeFind.models.dto.builders;

import com.RecipeFind.models.User;
import com.RecipeFind.models.dto.request.SignupRequest;
import com.RecipeFind.models.enums.UserRole;

public class AuthenticationDTOBuilder {

    private AuthenticationDTOBuilder() {
    }

    public static User fromSignupRequest(SignupRequest signupRequest) {
        return User.builder()
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .phone(signupRequest.getPhone())
                .email(signupRequest.getEmail())
                .role(signupRequest.getIsAdmin() != null && signupRequest.getIsAdmin()
                        ? UserRole.ROLE_ADMIN
                        : UserRole.ROLE_USER)
                .build();
    }

}
