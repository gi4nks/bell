package io.streamtune.bell.commands;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true,  version = "1.0",
        subcommands = {
        GetCommand.class,
        LastCommand.class,
        ConfigurationCommand.class,
        CleanupCommand.class, CreateCommand.class})
public class EntryCommand {
}