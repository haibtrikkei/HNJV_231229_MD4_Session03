package org.example.validattion_api_session03.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.validattion_api_session03.model.dto.request.AccountForm;
import org.example.validattion_api_session03.model.entity.Account;
import org.example.validattion_api_session03.repository.AccountRepository;
import org.example.validattion_api_session03.service.AccountService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

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
    public Account insert(AccountForm accountForm) {
        Account acc = Account.builder()
                .username(accountForm.getUsername())
                .password(BCrypt.hashpw(accountForm.getPassword(),BCrypt.gensalt(12)))
                .fullName(accountForm.getFullName())
                .birthday(accountForm.getBirthday())
                .address(accountForm.getAddress())
                .gender(accountForm.getGender())
                .email(accountForm.getEmail())
                .phone(accountForm.getPhone())
                .status(true)
                .build();

        return accountRepository.save(acc);
    }

    @Override
    public Account update(Account account) {
        accountRepository.findById(account.getAccountId()).orElseThrow(()->new NoSuchElementException("Khong ton tai account co id "+account.getAccountId()));
        account.setPassword(BCrypt.hashpw(account.getPassword(),BCrypt.gensalt(12)));
        return accountRepository.save(account);
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
