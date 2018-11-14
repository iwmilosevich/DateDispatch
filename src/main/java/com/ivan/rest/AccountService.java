package com.ivan.rest;

import com.ivan.database.Database;
import com.ivan.model.Account;
import com.ivan.model.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {
    private Database db = new Database();

    public AccountService() throws Exception {}

    @GET
    @Path("{id}")
    public Account get(@PathParam("id") long id) throws SQLException {
        Statement statement = db.getConnect().createStatement();
        ResultSet result = statement.executeQuery("select * from datedispatch.account where accountId = " + String.valueOf(id));
        result.first();
        Account account = new Account();
        account.setId(result.getLong("accountId"));
        account.setFirstName(result.getString("firstName"));
        account.setLastName(result.getString("LastName"));
        account.setEmail(result.getString("email"));
        account.setAddress(result.getString("Address"));
        return account;
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) throws SQLException {
        PreparedStatement statement = db.getConnect().prepareStatement("delete from datedispatch.account where accountId = "+ String.valueOf(id));
        statement.execute();
    }


    @POST
    @Path("")
    public Account post(Account account) throws SQLException {
        PreparedStatement statement = db.getConnect().prepareStatement("insert into datedispatch.account values (default, ?, ?, ?, ?)");
        statement.setString(1, account.getFirstName());
        statement.setString(2, account.getLastName());
        statement.setString(3, account.getEmail());
        statement.setString(4, account.getAddress());
        statement.executeUpdate();
        return account;
    }
}