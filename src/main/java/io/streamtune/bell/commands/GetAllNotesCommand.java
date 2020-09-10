package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetAllNotesCommandOutputFormatter;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "all", description = "Show all notes")
public class GetAllNotesCommand implements Runnable {
    @Inject
    private NoteService service;

    @Override
    public void run() {
        List<NoteDTO> notes = service.findAll();
        GetAllNotesCommandOutputFormatter formatter = new GetAllNotesCommandOutputFormatter(notes);
        formatter.print();
    }
}

