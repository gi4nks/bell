package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetLabelCommandOutputFormatter {
    private LabelDTO label;

    public GetLabelCommandOutputFormatter(LabelDTO label) {
        this.label = label;
    }

    public void print() {
        List<String> notes = label.getNotes().stream().map(l -> l.getValue()).collect(toList());

        String csv = String.join(",", notes);

        String[] headers = { "id", "value", "notes" };
        String[][] data = {
                { "[" + AnsiColors.ANSI_GREEN + label.getId() +
                        AnsiColors.ANSI_RESET + "]",
                        label.getValue(), csv }
        };
        System.out.println(FlipTable.of(headers, data));
    }
}
