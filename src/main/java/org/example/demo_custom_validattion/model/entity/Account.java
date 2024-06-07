package org.example.demo_custom_validattion.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.demo_custom_validattion.validator.ConfirmPasswordMatching;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfirmPasswordMatching(password = "password",confirmPassword = "confirmPassword")
public class Account {
    @NotBlank(message = "Username is empty")
    private String username;
    @NotBlank(message = "Password is empty")
    private String password;
    @NotBlank(message = "Fullname is empty")
    private String fullName;
    @NotBlank(message = "Address is empty")
    private String address;
    @NotBlank(message = "Email is empty")
    @Pattern(regexp = "^[a-zA-Z][_.\\w]*@\\w{3,}.\\w{2,5}(.\\w{2,5})?$",message = "Email is not valid")
    private String email;
    @NotBlank(message = "Phone is empty")
    @Pattern(regexp = "^0[349168]\\d{8,9}$",message = "Phone is not valid")
    private String phone;
    private String confirmPassword;
}
