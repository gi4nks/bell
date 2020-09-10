package io.streamtune.bell.commands;

import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;

import io.streamtune.bell.formatters.LastNoteCommandOutputFormatter;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "last", description = "Show the value of the last note")
public class LastNoteCommand implements Runnable {
    @Inject
    private NoteService service;

    @Override
    public void run() {
        NoteDTO note = service.findLast();

        LastNoteCommandOutputFormatter formatter = new LastNoteCommandOutputFormatter(note);
        formatter.print();
    }
}

