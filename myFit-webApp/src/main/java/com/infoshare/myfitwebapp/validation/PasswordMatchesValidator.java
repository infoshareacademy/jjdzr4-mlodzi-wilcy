package com.infoshare.myfitwebapp.validation;

import com.infoshare.myfitwebapp.entity.UserLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserLogin userLogin = (UserLogin) value;
        return userLogin.getPassword().equals(userLogin.getMatchingPassword());
    }
}
