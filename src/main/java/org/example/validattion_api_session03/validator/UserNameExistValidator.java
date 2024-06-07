package org.example.validattion_api_session03.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.validattion_api_session03.model.entity.Account;
import org.example.validattion_api_session03.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameExistValidator implements ConstraintValidator<UserNameExist,String> {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return accountRepository.findAccountByUsername(s) == null;
    }
}
