package io.streamtune.bell.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "label", description = "Label commands",
        subcommands = { GetNoteFromLabelCommand.class })
public class LabelCommand {
}

