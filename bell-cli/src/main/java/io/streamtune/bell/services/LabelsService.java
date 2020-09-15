package io.streamtune.bell.services;

import io.streamtune.bell.services.models.Label;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api/labels")
@RegisterRestClient
public interface LabelsService extends GenericService<Label> {

    @GET
    @Path("/value/{v}")
    @Produces("application/json")
    Label getByValue(@PathParam String v);
}
