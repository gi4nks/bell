package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.LastNoteCommandOutputFormatter;
import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "last", description = "Show the value of the last note")
public class LastNoteCommand implements Runnable {
    @Inject
    @RestClient
    NotesService service;

    @Override
    public void run() {
        Note note = service.findLast();

        LastNoteCommandOutputFormatter formatter = new LastNoteCommandOutputFormatter(note);
        formatter.print();
    }
}

