package com.ivan.controller;

import com.ivan.domain.Account;
import com.ivan.repository.AccountRepository;
import com.ivan.resource.AccountResource;
import com.ivan.resource.assembler.AccountResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Account.class)
@RequestMapping(value = "/account", produces = "application/json")
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountResourceAssembler assembler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<AccountResource>> findAllAccounts() {
        List<Account> accounts = repository.findAll();
        return new ResponseEntity<>(assembler.toResourceCollection(accounts), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AccountResource> createAccount(@RequestBody Account account) {
        Account createdAccount = repository.create(account);
        return new ResponseEntity<>(assembler.toResource(createdAccount), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountResource> findAccountById(@PathVariable Long id) {
        Optional<Account> account = repository.findById(id);

        if (account.isPresent()) {
            return new ResponseEntity<>(assembler.toResource(account.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<AccountResource> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount) {
        boolean wasUpdated = repository.update(id, updatedAccount);

        if (wasUpdated) {
            return findAccountById(id);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}