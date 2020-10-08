package io.streamtune.bell.web.rest;

import static javax.ws.rs.core.UriBuilder.fromPath;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.web.rest.errors.BadRequestAlertException;
import io.streamtune.bell.web.util.HeaderUtil;
import io.streamtune.bell.web.util.ResponseUtil;

@Path("/api/labels")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LabelResource {
    private final Logger log = LoggerFactory.getLogger(NoteResource.class);

    @ConfigProperty(name = "application.name")
    String applicationName;

    @Inject
    LabelService service;

    @POST
    @Counted(name = "LabelResource.create")
    public Response create(@Valid LabelDTO labelDTO) {
        log.info("REST request to save Label : {}", labelDTO);

        if (labelDTO.getId() != null) {
            throw new BadRequestAlertException("A new label cannot already have an ID", "labelManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else {
            LabelDTO label = service.create(labelDTO);

            Response.ResponseBuilder response =
                    Response.created(fromPath("/api/labels").path(labelDTO.getId().toString()).build()).entity(label);
            HeaderUtil.createAlert(applicationName, "labelManagement.created", label.getId().toString()).forEach(response::header);
            return response.build();
        }
    }

    @GET
    @Counted(name = "LabelResource.getAll")
    public Response getAll() {
        log.info("REST request to get all Labels");
        final List<LabelDTO> page = service.findAll();
        Response.ResponseBuilder response = Response.ok(page);
        return response.build();
    }

    @GET
    @Counted(name = "LabelResource.getOne")
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        log.info("REST request to get Label: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(service.findById(id)));
    }

    @Path("/{id}")
    @Counted(name = "LabelResource.delete")
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        log.info("REST request to delete Label: {}", id);
        service.delete(id);
        Response.ResponseBuilder response = Response.noContent();
        HeaderUtil.createAlert(applicationName, "labelManagement.deleted", id.toString()).forEach(response::header);
        return response.build();
    }

}
