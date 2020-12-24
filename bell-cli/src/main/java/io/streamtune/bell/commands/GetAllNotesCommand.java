package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetAllNotesCommandOutputFormatter;
import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "all", description = "Show all notes")
public class GetAllNotesCommand implements Runnable {
    @ConfigProperty(name = "io.streamtune.bell.userKey") 
    String userKey;


    @Inject
    @RestClient
    NotesService service;

    @Override
    public void run() {
        List<Note> notes = service.all(userKey);
        GetAllNotesCommandOutputFormatter formatter = new GetAllNotesCommandOutputFormatter(notes);
        formatter.print();
    }
}

