package io.streamtune.bell.commands;

import io.streamtune.bell.services.NotesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "cleanup", description = "Deletes all of your stored notes")
public class CleanupCommand implements Runnable {
    @Inject
    @RestClient
    NotesService noteService;

    @Override
    public void run() {
        System.out.println("Truncating entire bell db");
        noteService.truncateAll();
        System.out.println("Done!");
    }
}

