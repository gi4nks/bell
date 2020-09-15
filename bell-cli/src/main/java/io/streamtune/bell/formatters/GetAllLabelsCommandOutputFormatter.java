package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.models.Label;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

public class GetAllLabelsCommandOutputFormatter {
    private List<Label> labels;

    public GetAllLabelsCommandOutputFormatter(List<Label> labels) {
        this.labels = labels;
    }

    public void print() {

        String[] headers = { "id", "value" };
        String[][] data = new String[][]{ {"a", "b"} };

        if (labels!=null && labels.size()>0) {
            data = new String[this.labels.size()][2];

            for (int i = 0; i < labels.size(); i++) {
                Label label = labels.get(i);

                data[i][0] = "[" + AnsiColors.ANSI_GREEN + label.id +
                        AnsiColors.ANSI_RESET + "]";
                data[i][1] = label.value;
            }
        }
        System.out.println(FlipTable.of(headers, data));
    }
}
