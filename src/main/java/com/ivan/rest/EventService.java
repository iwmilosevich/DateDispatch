package com.ivan.rest;

import com.ivan.database.Database;
import com.ivan.model.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventService {
    private Database db = new Database();

    public EventService() throws Exception {}

    @GET
    @Path("{id}")
    public Event get(@PathParam("id") long id) throws SQLException {
        Statement statement = db.getConnect().createStatement();
        ResultSet result = statement.executeQuery("select * from datedispatch.event where EventId = " + String.valueOf(id));
        result.first();
        Event event = new Event();
        event.setId(result.getLong("eventId"));
        event.setName(result.getString("eventName"));
        event.setDescription(result.getString("description"));
        return event;
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) throws SQLException {
        PreparedStatement statement = db.getConnect().prepareStatement("delete from datedispatch.event where eventId = "+ String.valueOf(id));
        statement.execute();
    }


    @POST
    @Path("")
    public Event post(Event event) throws SQLException {
        PreparedStatement statement = db.getConnect().prepareStatement("insert into datedispatch.event values (default, ?, ?)");
        statement.setString(1, event.getName());
        statement.setString(2, event.getDescription());
        statement.executeUpdate();
        ResultSet result = statement.getResultSet();
        return event;
    }
}
