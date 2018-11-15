package com.ivan.repository;

import com.ivan.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository extends InMemoryRepository<Account> {

    protected void updateIfExists(Account original, Account updated) {
        original.setFirstName(updated.getFirstName());
        original.setLastName(updated.getLastName());
        original.setEmail(updated.getEmail());
        original.setAddress(updated.getAddress());
    }
}