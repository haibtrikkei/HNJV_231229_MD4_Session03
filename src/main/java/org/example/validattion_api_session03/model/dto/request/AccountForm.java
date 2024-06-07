package org.example.validattion_api_session03.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.validattion_api_session03.validator.UserNameExist;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountForm {
    @NotBlank(message = "Username is empty")
    @UserNameExist
    private String username;
    @NotBlank(message = "Password is empty")
    private String password;
    @NotBlank(message = "Fullname is empty")
    private String fullName;
    @NotNull(message = "Gender is empty")
    private Boolean gender;
    @NotNull(message = "Birthday is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthday is not valid")
    private Date birthday;
    @NotBlank(message = "Address is empty")
    private String address;
    @NotBlank(message = "Email is empty")
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message = "Phone is empty")
    private String phone;
    private Boolean status;
}
