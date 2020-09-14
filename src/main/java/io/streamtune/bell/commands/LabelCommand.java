package io.streamtune.bell.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "label", description = "Label commands",
        subcommands = { GetNoteFromLabelCommand.class, GetAllLabelsCommand.class, GetLabelCommand.class })
public class LabelCommand {
}

