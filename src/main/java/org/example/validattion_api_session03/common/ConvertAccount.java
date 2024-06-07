package org.example.validattion_api_session03.common;

import lombok.*;
import org.example.validattion_api_session03.model.dto.request.AccountForm;
import org.example.validattion_api_session03.model.entity.Account;
import org.mindrot.jbcrypt.BCrypt;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ConvertAccount {
    public Account toAccount(AccountForm accountForm, Boolean status){
       return Account.builder()
                .username(accountForm.getUsername())
                .password(BCrypt.hashpw(accountForm.getPassword(),BCrypt.gensalt(12)))
                .fullName(accountForm.getFullName())
                .birthday(accountForm.getBirthday())
                .address(accountForm.getAddress())
                .gender(accountForm.getGender())
                .email(accountForm.getEmail())
                .phone(accountForm.getPhone())
                .status(status)
                .build();
    }
}
