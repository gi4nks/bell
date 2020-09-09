package io.streamtune.bell.commands;

import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;

import io.streamtune.bell.formatters.LastCommandOutputFormatter;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CommandLine.Command(name = "last", description = "Show the value of the last note")
public class LastCommand implements Runnable {
    @Inject
    private NoteService service;

    @Override
    public void run() {
        NoteDTO note = service.findLast();

        LastCommandOutputFormatter formatter = new LastCommandOutputFormatter(note);
        formatter.print();
    }
}

