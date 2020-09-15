package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetNotesFromLabelCommandFormatter;
import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "label", description = "Shows all the note in a label")
public class GetNoteFromLabelCommand implements Runnable {
    @Inject
    @RestClient
    NotesService service;

    @CommandLine.Option(names = {"-l", "--lbl"}, description = "the label")
    String lbl;

    @Override
    public void run() {
        List<Note> notes = service.findByLabel(lbl);
        GetNotesFromLabelCommandFormatter formatter = new GetNotesFromLabelCommandFormatter(notes);
        formatter.print();
    }
}

