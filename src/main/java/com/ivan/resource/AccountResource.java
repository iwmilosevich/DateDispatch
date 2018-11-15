package com.ivan.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivan.domain.Account;
import org.springframework.hateoas.ResourceSupport;

public class AccountResource extends ResourceSupport
{

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;

    public AccountResource(Account account) {
        id = account.getId();
        firstName = account.getFirstName();
        lastName = account.getLastName();
        email = account.getEmail();
        address = account.getAddress();
    }

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

