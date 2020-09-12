package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetNoteCommandOutputFormatter;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import static java.util.stream.Collectors.toMap;

import javax.inject.Inject;

@CommandLine.Command(name = "get", description = "Show the value of a note")
public class GetNoteCommand implements Runnable {
    @Inject
    NoteService service;

    @CommandLine.Option(names = {"-i", "--id"}, description = "the id of the note to show")
    String id;

    @Override
    public void run() {
        NoteDTO note = service.findById(Long.parseLong(this.id));
        GetNoteCommandOutputFormatter formatter = new GetNoteCommandOutputFormatter(note);
        formatter.print();
    }
}

