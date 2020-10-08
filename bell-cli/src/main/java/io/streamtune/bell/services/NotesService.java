package io.streamtune.bell.services;

import io.streamtune.bell.services.fallbacks.NoteFallback;
import io.streamtune.bell.services.fallbacks.NotesFallback;
import io.streamtune.bell.services.models.Note;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.List;

@Path("/api/notes")
@RegisterRestClient
public interface NotesService extends GenericService<Note> {
    @POST
    @Produces("application/json")
    @Retry(maxRetries = 3, delay = 2000)
    @Fallback(NoteFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000)
    Note create(Note note);

    @GET
    @Path("/label/{v}")
    @Produces("application/json")
    @Retry(maxRetries = 3, delay = 2000)
    @Fallback(NotesFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000)
    List<Note> findByLabel(@PathParam("v") String v);

    @GET
    @Path("/last")
    @Produces("application/json")
    @Retry(maxRetries = 3, delay = 2000)
    @Fallback(NoteFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000)
    Note findLast();
}