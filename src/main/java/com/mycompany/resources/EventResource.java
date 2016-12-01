package com.mycompany.resources;

import com.mycompany.api.Event;
import com.mycompany.core.EventRepository;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    private EventRepository repository;

    public EventResource(EventRepository repository) {
        this.repository = repository;
    }

    @GET
    public List<Event> allEvents() {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    public Event event(@PathParam("id") LongParam id) {
        return repository.findById(id.get())
                .orElseThrow(() ->
                        new WebApplicationException("Event not found", 404));
    }

    @POST
    public Event create(Event event) {
        return repository.save(event);
    }

    @PUT
    @Path("{id}")
    public Event update(@PathParam("id") LongParam id, Event event) {
        return repository.update(id.get(), event)
                .orElseThrow(() ->
                        new WebApplicationException("Event not found", 404));
    }
}
