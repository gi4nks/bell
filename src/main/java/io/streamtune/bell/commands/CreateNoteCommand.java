package io.streamtune.bell.commands;

import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@CommandLine.Command(name = "create", description = "Create a note")
public class CreateNoteCommand implements Runnable {
    @Inject
    private NoteService noteService;

    @CommandLine.Option(names = {"-n", "--note"}, description = "note to store")
    String note;

    @CommandLine.Option(names = {"-l", "--labels"}, description = "comma separated labels")
    String labels;

    @Override
    public void run() {
        System.out.println("Storing note: " + note);
        List<String> lbls = Arrays.asList(labels.split(","));

        NoteDTO nt = noteService.create(note, lbls);
        System.out.println(nt.getValue());
        System.out.format("[" + AnsiColors.ANSI_GREEN + "%s" + AnsiColors.ANSI_RESET + "]\n", nt.getId());

    }
}

