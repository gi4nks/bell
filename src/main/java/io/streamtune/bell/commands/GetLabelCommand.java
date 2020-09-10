package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetNoteCommandOutputFormatter;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "get", description = "Show the value of a label")
public class GetLabelCommand implements Runnable {
    @Inject
    private LabelService service;

    @CommandLine.Option(names = {"-i", "--id"}, description = "the id of the note to label")
    String id;

    @Override
    public void run() {
        /*
        NoteDTO note = service.findById(Long.parseLong(this.id));
        GetNoteCommandOutputFormatter formatter = new GetNoteCommandOutputFormatter(note);


        formatter.print();

         */
    }
}

