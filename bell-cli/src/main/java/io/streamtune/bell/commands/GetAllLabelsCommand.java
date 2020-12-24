package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetAllLabelsCommandOutputFormatter;
import io.streamtune.bell.services.LabelsService;
import io.streamtune.bell.services.models.Label;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "all", description = "Show all labels")
public class GetAllLabelsCommand implements Runnable {
    @ConfigProperty(name = "io.streamtune.bell.userKey") 
    String userKey;

    @Inject
    @RestClient
    LabelsService service;

    @Override
    public void run() {
        List<Label> labels = service.all(userKey);
        GetAllLabelsCommandOutputFormatter formatter = new GetAllLabelsCommandOutputFormatter(labels);
        formatter.print();
    }
}

