package io.streamtune.bell.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "label", description = "Label commands",
        subcommands = { GetLabelCommand.class, GetAllLabelsCommand.class })
public class LabelCommand {
}

