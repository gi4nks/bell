package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetNoteCommandOutputFormatter;
import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "get", description = "Show the value of a note")
public class GetNoteCommand implements Runnable {
    @Inject
    @RestClient
    NotesService service;

    @CommandLine.Option(names = {"-i", "--id"}, description = "the id of the note to show")
    String id;

    @Override
    public void run() {
        Note note = service.getById(Long.parseLong(this.id));
        GetNoteCommandOutputFormatter formatter = new GetNoteCommandOutputFormatter(note);
        formatter.print();
    }
}

