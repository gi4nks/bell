package io.streamtune.bell.web.rest;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.web.rest.errors.BadRequestAlertException;
import io.streamtune.bell.web.util.HeaderUtil;
import io.streamtune.bell.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.ws.rs.core.UriBuilder.fromPath;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@Path("/api/notes")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteResource {
    private final Logger log = LoggerFactory.getLogger(NoteResource.class);

    @ConfigProperty(name = "application.name")
    String applicationName;

    @Inject
    NoteService service;

    @POST
    public Response create(@Valid NoteDTO noteDTO) {
        log.info("REST request to save Note : {}", noteDTO);

        if (noteDTO.getId() != null) {
            throw new BadRequestAlertException("A new note cannot already have an ID", "noteManagement", "idexists");
            // Lowercase the user login before comparing with database
        } else {
            noteDTO = service.create(noteDTO);

            Response.ResponseBuilder response =
                    Response.created(fromPath("/api/notes").path(noteDTO.getId().toString()).build()).entity(noteDTO);
            HeaderUtil.createAlert(applicationName, "noteManagement.created", noteDTO.getId().toString()).forEach(response::header);
            return response.build();
        }
    }

    @GET
    public Response getAll() {
        log.info("REST request to get all Notes");
        final List<NoteDTO> page = service.findAll();
        Response.ResponseBuilder response = Response.ok(page);
        return response.build();
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        log.info("REST request to get Note: {}", id);
        return ResponseUtil.wrapOrNotFound(Optional.of(service.findById(id)));
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        log.info("REST request to delete Note: {}", id);
        service.delete(id);
        Response.ResponseBuilder response = Response.noContent();
        HeaderUtil.createAlert(applicationName, "noteManagement.deleted", id.toString()).forEach(response::header);
        return response.build();
    }

    @GET
    @Path("/label/{v}")
    public Response getByValue(@PathParam("v") String v) {
        log.info("REST request to get Note: {}", v);
        return ResponseUtil.wrapOrNotFound(Optional.of(service.findByLabel(v)));
    }

    @GET
    @Path("/last")
    public Response getLast() {
        log.info("REST request to get last Note");
        return ResponseUtil.wrapOrNotFound(Optional.of(service.findLast()));
    }

}
