package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetNotesFromLabelCommandFormatter;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "get", description = "Shows all the note in a label")
public class GetNoteFromLabelCommand implements Runnable {
    @Inject
    LabelService service;

    @CommandLine.Option(names = {"-l", "--lbl"}, description = "the label")
    String lbl;

    @Override
    public void run() {
        List<NoteDTO> notes = service.findByLabel(lbl);
        GetNotesFromLabelCommandFormatter formatter = new GetNotesFromLabelCommandFormatter(notes);
        formatter.print();
    }
}

