package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.models.Note;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllNotesCommandOutputFormatter {
    private List<Note> notes;

    public GetAllNotesCommandOutputFormatter(List<Note> notes) {
        this.notes = notes;
    }

    public void print() {
        String[] headers = { "id", "value", "labels" };
        String[][] data = new String[this.notes.size()][3];

        for (int i=0; i<notes.size(); i++) {
            Note note = notes.get(i);

            List<String> lbls = note.labels.stream().map(l -> l.value).collect(toList());

            String csv = String.join(",", lbls);

            data[i][0] = "[" + AnsiColors.ANSI_GREEN + note.id +
                            AnsiColors.ANSI_RESET + "]";
            data[i][1] = note.value;
            data[i][2] = csv;
        }
        System.out.println(FlipTable.of(headers, data));
    }
}
