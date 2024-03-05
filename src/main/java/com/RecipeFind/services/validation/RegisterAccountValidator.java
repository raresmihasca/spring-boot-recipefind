package com.RecipeFind.services.validation;

import com.RecipeFind.models.dto.request.SignupRequest;
import com.RecipeFind.services.validation.utils.ValidatorException;
import org.springframework.stereotype.Component;

@Component
public class RegisterAccountValidator extends AccountValidator {
    public void validate(SignupRequest signupRequest) throws ValidatorException, ValidatorException {
        validateName(signupRequest.getFirstName());
        validateName(signupRequest.getLastName());
        validateEmail(signupRequest.getEmail());
        validatePassword(signupRequest.getPassword());
        validatePhoneNumber(signupRequest.getPhone());
    }
}
