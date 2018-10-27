package com.ivan.rest;

import com.ivan.data.AccountList;
import com.ivan.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

    private final CopyOnWriteArrayList<Account> accounts = AccountList.getInstance();

    @GET
    @Path("{id}")
    public Optional<Account> get(@PathParam("id") long id) {
        return accounts.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Path("all")
    @GET
    @Produces("application/json")
    public List<Account> all() {
        return accounts;
    }
}