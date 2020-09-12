package io.streamtune.bell.commands;

import io.streamtune.bell.formatters.GetAllLabelsCommandOutputFormatter;
import io.streamtune.bell.formatters.GetAllNotesCommandOutputFormatter;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import picocli.CommandLine;

import javax.inject.Inject;
import java.util.List;

@CommandLine.Command(name = "all", description = "Show all labels")
public class GetAllLabelsCommand implements Runnable {
    @Inject
    LabelService service;

    @Override
    public void run() {
        List<LabelDTO> labels = service.findAll();
        GetAllLabelsCommandOutputFormatter formatter = new GetAllLabelsCommandOutputFormatter(labels);
        formatter.print();
    }
}

