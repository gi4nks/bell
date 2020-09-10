package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.entities.Label;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllLabelsCommandOutputFormatter {
    private List<LabelDTO> labels;

    public GetAllLabelsCommandOutputFormatter(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public void print() {

        String[] headers = { "id", "value" };
        String[][] data = new String[][]{ {"a", "b"} };

        if (labels!=null && labels.size()>0) {
            data = new String[this.labels.size()][2];

            for (int i = 0; i < labels.size(); i++) {
                LabelDTO label = labels.get(i);

                data[i][0] = "[" + AnsiColors.ANSI_GREEN + label.getId() +
                        AnsiColors.ANSI_RESET + "]";
                data[i][1] = label.getValue();
            }
        }
        System.out.println(FlipTable.of(headers, data));
    }
}
