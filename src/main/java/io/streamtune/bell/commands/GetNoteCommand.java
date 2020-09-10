package io.streamtune.bell.commands;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.formatters.GetCommandOutputFormatter;
import io.streamtune.bell.formatters.LastCommandOutputFormatter;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;
import picocli.CommandLine;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CommandLine.Command(name = "get", description = "Show the value of a note")
public class GetNoteCommand implements Runnable {
    @Inject
    private NoteService service;

    @CommandLine.Option(names = {"-i", "--id"}, description = "the id of the note to show")
    String id;

    @Override
    public void run() {
        NoteDTO note = service.findById(Long.parseLong(this.id));
        GetCommandOutputFormatter formatter = new GetCommandOutputFormatter(note);
        formatter.print();
    }
}

