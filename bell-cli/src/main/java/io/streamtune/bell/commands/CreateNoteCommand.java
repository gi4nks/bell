package io.streamtune.bell.commands;

import io.streamtune.bell.services.NotesService;
import io.streamtune.bell.services.models.Note;
import io.streamtune.bell.utils.AnsiColors;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.*;

@CommandLine.Command(name = "create", description = "Create a note")
public class CreateNoteCommand implements Runnable {
    @ConfigProperty(name = "io.streamtune.bell.userKey") 
    String userKey;

    @Inject
    @RestClient
    NotesService noteService;

    @CommandLine.Option(names = {"-n", "--note"}, description = "note to store")
    String note;

    @CommandLine.Option(names = {"-l", "--labels"}, description = "comma separated labels")
    String labels;

    @Override
    public void run() {
        Note nt = new Note();
        nt.value=note;

        List<String> lbls = Arrays.asList(labels.split(","));

        List<Note.Label> labels = new ArrayList<>();
        for (String label : lbls) {
            Note.Label nl = new Note.Label();
            nl.value = label;

            labels.add(nl);
        }

        System.out.println(nt.toString());
        nt.labels=labels;
        nt = noteService.create(userKey, nt);
        System.out.println(nt.value);
        System.out.format("[" + AnsiColors.ANSI_GREEN + "%s" + AnsiColors.ANSI_RESET + "]\n", nt.id);
    }
}

