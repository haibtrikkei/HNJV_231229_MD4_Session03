package org.example.validattion_api_session03.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.example.validattion_api_session03.validator.UserNameExist;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    @Column(nullable = false,unique = true)
    @UserNameExist
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(nullable = false,length = 70)
    private String fullName;
    @NotNull(message = "Gender is empty")
    private Boolean gender;
    @NotNull(message = "Birthday is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthday is not valid")
    private Date birthday;
    @Column(length = 200)
    private String address;
    @Column(nullable = false,unique = true)
    @Email
    private String email;
    private String phone;
    private Boolean status;
}
