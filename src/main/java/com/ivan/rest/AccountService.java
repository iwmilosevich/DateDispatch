package com.ivan.rest;

import com.ivan.data.AccountList;
import com.ivan.model.Account;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountService {

    private final CopyOnWriteArrayList<Account> cList = AccountList.getInstance();

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllAccounts() {
        return "---Account List---\n"
                + cList.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining("\n"));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAccount(@PathParam("id") long id) {
        Optional<Account> match = cList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if (match.isPresent()) {
            return "---Customer---\n" + match.get().toString();
        } else {
            return "Customer not found";
        }
    }
}