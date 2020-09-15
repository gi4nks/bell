package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.models.Note;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetNotesFromLabelCommandFormatter {
    private List<Note> notes;

    public GetNotesFromLabelCommandFormatter(List<Note> notes) {
        this.notes = notes;
    }

    public void print() {
        String[] headers = { "id", "value", "labels", "createdAt" };
        String[][] data = new String[this.notes.size()][4];

        for (int i=0; i<notes.size(); i++) {
            Note note = notes.get(i);

            List<String> lbls = note.labels.stream().map(l -> l.value).collect(toList());

            String csv = String.join(",", lbls);

            data[i][0] = "[" + AnsiColors.ANSI_GREEN + note.id +
                    AnsiColors.ANSI_RESET + "]";
            data[i][1] = note.value;
            data[i][2] = csv;
            data[i][3] = String.valueOf(note.createdAt);
        }
        System.out.println(FlipTable.of(headers, data));
    }
}
