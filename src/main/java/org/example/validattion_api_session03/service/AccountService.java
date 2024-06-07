package org.example.validattion_api_session03.service;

import org.example.validattion_api_session03.model.dto.request.AccountForm;
import org.example.validattion_api_session03.model.entity.Account;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findByUsername(String userName);
    Account insert(AccountForm accountForm);
    Account update(Account account);
    void delete(Integer accountId);
    List<Account> findByName(String name);
}
