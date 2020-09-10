package io.streamtune.bell.commands;

import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@CommandLine.Command(name = "note", description = "Note commands", subcommands = { GetNoteCommand.class,
        CreateNoteCommand.class, GetAllNotesCommand.class, LastNoteCommand.class })
public class NoteCommand {
}

