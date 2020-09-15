package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.models.Note;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetNoteCommandOutputFormatter {
    private Note note;

    public GetNoteCommandOutputFormatter(Note note) {
        this.note = note;
    }

    public void print() {
        List<String> lbls = note.labels.stream().map(l -> l.value).collect(toList());

        String csv = String.join(",", lbls);

        String[] headers = { "id", "value", "labels", "createdAt" };
        String[][] data = {
                { "[" + AnsiColors.ANSI_GREEN + note.id +
                        AnsiColors.ANSI_RESET + "]",
                        note.value, csv, String.valueOf(note.createdAt) }
        };
        System.out.println(FlipTable.of(headers, data));
    }
}
