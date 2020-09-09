package io.streamtune.bell.commands;


import io.streamtune.bell.utils.BellConfiguration;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "configuration", description = "Returns the current configuration of bell")
public class ConfigurationCommand implements Runnable {
    @Inject
    BellConfiguration bellConfiguration;

    public ConfigurationCommand() {
    }

    @Override
    public void run() {
        System.out.println("bell Configuration command output:");
        System.out.println(bellConfiguration.toString());
    }

}