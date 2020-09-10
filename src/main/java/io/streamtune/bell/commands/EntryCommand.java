package io.streamtune.bell.commands;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true,  version = "1.0",
        subcommands = {
        NoteCommand.class,
        LabelCommand.class,
        ConfigurationCommand.class,
        CleanupCommand.class})
public class EntryCommand {
}