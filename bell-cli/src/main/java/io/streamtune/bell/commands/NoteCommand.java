package io.streamtune.bell.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "note", description = "Note commands", subcommands = { GetNoteCommand.class,
        CreateNoteCommand.class, GetAllNotesCommand.class, LastNoteCommand.class,
        GetNoteFromLabelCommand.class})
public class NoteCommand {
}

