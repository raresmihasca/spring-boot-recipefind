package com.RecipeFind.services.validation;

import com.RecipeFind.services.validation.utils.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AccountValidator {
    protected void validateEmail(String email) throws ValidatorException{
        if (email == null || email.isEmpty()) {
            throw new ValidatorException("Email cannot be empty");
        }
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Za-z0-9._%+-]+@[a-z.-]+\\.(com|ro)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        if (!matcher.find()) {
            throw new ValidatorException("Invalid email format");
        }
    }


    protected void validatePassword(String password) throws ValidatorException{
        if (password == null || password.isEmpty()) {
            throw new ValidatorException("Password cannot be empty");
        }

        if (password.length() < 8) {
            throw new ValidatorException("Password must have at least 8 characters");
        }
    }

    protected void validateName(String name) throws ValidatorException {
        if (name == null || name.isEmpty()) {
            throw new ValidatorException("Name cannot be empty");
        }

        if (!name.matches("^[A-Za-z -]+$")) {
            throw new ValidatorException("Name can't contain digits!");
        }
    }

    protected void validatePhoneNumber(String phoneNumber) throws ValidatorException{
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new ValidatorException("Phone number cannot be empty");
        }

        if (phoneNumber.length() != 10) {
            throw new ValidatorException("Invalid phone number length");
        }

        final Pattern VALID_TELEPHONE_NUMBER_REGEX = Pattern.compile("^0(2|7)[0-9]+$");
        Matcher matcher = VALID_TELEPHONE_NUMBER_REGEX.matcher(phoneNumber);

        if (!matcher.find()) {
            throw new ValidatorException("Invalid phone number format");
        }
    }

}
