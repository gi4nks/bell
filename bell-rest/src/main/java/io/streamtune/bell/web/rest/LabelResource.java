package io.streamtune.bell.web.rest;

import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.web.rest.errors.BadRequestAlertException;
import io.streamtune.bell.web.util.HeaderUtil;
import io.streamtune.bell.web.util.ResponseUtil;
import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.ws.rs.core.UriBuilder.fromPath;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

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
    public Response getAll() {
        log.info("REST request to get all Labels");
        final List<LabelDTO> page = service.findAll();
        Response.ResponseBuilder response = Response.ok(page);
        return response.build();
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        log.info("REST request to get Label: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(service.findById(id)));
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        log.info("REST request to delete Label: {}", id);
        service.delete(id);
        Response.ResponseBuilder response = Response.noContent();
        HeaderUtil.createAlert(applicationName, "labelManagement.deleted", id.toString()).forEach(response::header);
        return response.build();
    }

}
