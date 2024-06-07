package org.example.validattion_api_session03.repository;

import org.example.validattion_api_session03.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Integer>, JpaRepository<Account,Integer> {
//    @Query("select acc from Account acc where acc.fullName like concat('%',:name,'%')")
    List<Account> findAccountsByFullNameContains(String name);
    Account findAccountByUsername(String username);
}
