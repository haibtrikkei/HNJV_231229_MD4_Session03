package org.example.validattion_api_session03.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.validattion_api_session03.common.ConvertAccount;
import org.example.validattion_api_session03.exception.DataException;
import org.example.validattion_api_session03.model.dto.request.AccountForm;
import org.example.validattion_api_session03.model.entity.Account;
import org.example.validattion_api_session03.repository.AccountRepository;
import org.example.validattion_api_session03.service.AccountService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ConvertAccount convertAccount;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String userName) {
        Account acc = accountRepository.findAccountByUsername(userName);
        if(acc==null){
            throw new NoSuchElementException("Khong ton tai account co username "+userName);
        }else{
            return acc;
        }
    }

    @Override
    public Account insert(AccountForm accountForm) throws DataException {
        Account account = accountRepository.findAccountByUsername(accountForm.getUsername());
        if(account!=null)
            throw new DataException("usernameError","Username existed!");

        Account acc = convertAccount.toAccount(accountForm,true);

        return accountRepository.save(acc);
    }

    @Override
    public Account update(AccountForm accountForm, Integer accountId) {
        accountRepository.findById(accountId).orElseThrow(()->new NoSuchElementException("Khong ton tai account co id "+accountId));
        Account acc = convertAccount.toAccount(accountForm,accountForm.getStatus());
        acc.setAccountId(accountId);
        return accountRepository.save(acc);
    }

    @Override
    public void delete(Integer accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Account> findByName(String name) {
        return accountRepository.findAccountsByFullNameContains(name);
    }
}
