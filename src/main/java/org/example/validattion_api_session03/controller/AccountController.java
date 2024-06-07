package org.example.validattion_api_session03.controller;

import jakarta.validation.Valid;
import org.example.validattion_api_session03.exception.DataException;
import org.example.validattion_api_session03.model.dto.request.AccountForm;
import org.example.validattion_api_session03.model.dto.response.DataResonse;
import org.example.validattion_api_session03.model.entity.Account;
import org.example.validattion_api_session03.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<DataResonse<List<Account>>> getAll(){
        return new ResponseEntity<>(new DataResonse<>(accountService.findAll(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<DataResonse<Account>> getAccountByUsername(@PathVariable String userName){
        return new ResponseEntity<>(new DataResonse<>(accountService.findByUsername(userName),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResonse<Account>> insertAccount(@Valid @RequestBody AccountForm accountForm) throws DataException {
        return new ResponseEntity<>(new DataResonse<>(accountService.insert(accountForm),HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<DataResonse<Account>> updateAccount(@Valid @RequestBody AccountForm accountForm, @PathVariable Integer accountId){
        return new ResponseEntity<>(new DataResonse<>(accountService.update(accountForm,accountId),HttpStatus.OK), HttpStatus.OK);
    }

}
