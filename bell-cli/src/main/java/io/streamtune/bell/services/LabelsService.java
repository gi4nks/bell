package io.streamtune.bell.services;

import io.streamtune.bell.services.fallbacks.LabelFallback;
import io.streamtune.bell.services.models.Label;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
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
    @Retry(maxRetries = 3, delay = 2000)
    @Fallback(LabelFallback.class)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000)
    Label getByValue(@PathParam String v);
}
