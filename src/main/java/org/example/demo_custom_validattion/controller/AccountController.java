package org.example.demo_custom_validattion.controller;

import jakarta.validation.Valid;
import org.example.demo_custom_validattion.model.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @PostMapping
    public ResponseEntity<String> saveAccount(@Validated @RequestBody Account account){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
