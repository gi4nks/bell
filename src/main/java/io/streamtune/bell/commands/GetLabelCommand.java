package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetLabelCommandOutputFormatter;
import io.streamtune.bell.formatters.GetNoteCommandOutputFormatter;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "get", description = "Show the value of a label")
public class GetLabelCommand implements Runnable {
    @Inject
    LabelService service;

    @CommandLine.Option(names = {"-v", "--value"}, description = "the value of the label")
    String v;

    @Override
    public void run() {
        LabelDTO label = service.findByValue(this.v);
        GetLabelCommandOutputFormatter formatter = new GetLabelCommandOutputFormatter(label);
        formatter.print();
    }
}

