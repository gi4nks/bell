package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.LastNoteCommandOutputFormatter;
import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "last", description = "Show the value of the last note")
public class LastNoteCommand implements Runnable {
    @ConfigProperty(name = "io.streamtune.bell.userKey") 
    String userKey;
    
    @Inject
    @RestClient
    NotesService service;

    @Override
    public void run() {
        Note note = service.findLast(userKey);

        LastNoteCommandOutputFormatter formatter = new LastNoteCommandOutputFormatter(note);
        formatter.print();
    }
}

