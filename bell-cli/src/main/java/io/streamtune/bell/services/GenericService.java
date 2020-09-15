package io.streamtune.bell.services;

import javax.ws.rs.*;
import java.util.List;

public interface GenericService<T> {
    @GET
    @Path("/{id}")
    @Produces("application/json")
    T getById(@PathParam("id") Long id);

    @GET
    @Path("/")
    @Produces("application/json")
    List<T> all();

    @DELETE
    @Produces("application/json")
    void truncateAll();
}
