package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetLabelCommandOutputFormatter;
import io.streamtune.bell.services.LabelsService;
import io.streamtune.bell.services.models.Label;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "get", description = "Show the value of a label")
public class GetLabelCommand implements Runnable {
    @Inject
    @RestClient
    LabelsService service;

    @CommandLine.Option(names = {"-v", "--value"}, description = "the value of the label")
    String v;

    @Override
    public void run() {
        Label label = service.getByValue(this.v);
        GetLabelCommandOutputFormatter formatter = new GetLabelCommandOutputFormatter(label);
        formatter.print();
    }
}

