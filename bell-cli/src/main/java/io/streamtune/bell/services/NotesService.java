package io.streamtune.bell.services;

import io.streamtune.bell.services.models.Note;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/notes")
@RegisterRestClient
public interface NotesService extends GenericService<Note> {
    @POST
    @Produces("application/json")
    Note create(Note note);

    @GET
    @Path("/label/{v}")
    @Produces("application/json")
    List<Note> findByLabel(@PathParam("v") String v);

    @GET
    @Path("/last")
    @Produces("application/json")
    Note findLast();
}