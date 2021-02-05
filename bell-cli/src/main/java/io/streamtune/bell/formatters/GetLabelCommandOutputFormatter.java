package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.models.Label;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetLabelCommandOutputFormatter {
    private Label label;

    public GetLabelCommandOutputFormatter(Label label) {
        this.label = label;
    }

    public void print() {
        //List<String> notes = label.notes.stream().map(l -> l.value).collect(toList());

        //String csv = String.join(",", notes);
        String csv = "";

    String[] headers = { "id", "value"/*, "notes"*/ };
        String[][] data = {
                { "[" + AnsiColors.ANSI_GREEN + label.id +
                        AnsiColors.ANSI_RESET + "]",
        label.value/*, csv*/ }
        };
        System.out.println(FlipTable.of(headers, data));
    }
}
