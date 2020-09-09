package io.streamtune.bell.commands;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;
import picocli.CommandLine;

import javax.inject.Inject;
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
        System.out.println(note.getValue());
        for (LabelDTO l : note.getLabels()) {
            System.out.format("[" + AnsiColors.ANSI_RED + "%s" + AnsiColors.ANSI_RESET + "]\n", l.getValue());
        }
        System.out.format("[" + AnsiColors.ANSI_GREEN + "%s" + AnsiColors.ANSI_RESET + "]\n", note.getId());
    }
}

