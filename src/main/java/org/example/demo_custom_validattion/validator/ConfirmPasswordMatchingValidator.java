package org.example.demo_custom_validattion.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Objects;

public class ConfirmPasswordMatchingValidator implements ConstraintValidator<ConfirmPasswordMatching,Object> {
    private String password;
    private String confirmPassword;

    @Override
    public void initialize(ConfirmPasswordMatching matching) {
        password = matching.password();
        confirmPassword = matching.confirmPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordValue = new BeanWrapperImpl(o).getPropertyValue(password);
        Object confirmPasswordValue = new BeanWrapperImpl(o).getPropertyValue(confirmPassword);
        return Objects.equals(passwordValue,confirmPasswordValue);
    }
}
