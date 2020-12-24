package io.streamtune.bell.services;

import javax.ws.rs.*;
import java.util.List;

public interface GenericService<T> {
    @GET
    @Path("/{id}")
    @Produces("application/json")
    T getById(@QueryParam("user_key") String userKey, @PathParam("id") Long id);

    @GET
    @Path("/")
    @Produces("application/json")
    List<T> all(@QueryParam("user_key") String userKey);

    @DELETE
    @Produces("application/json")
    void truncateAll(@QueryParam("user_key") String userKey);
}
