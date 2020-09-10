package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetNoteCommandOutputFormatter {
    private NoteDTO note;

    public GetNoteCommandOutputFormatter(NoteDTO note) {
        this.note = note;
    }

    public void print() {
        List<String> lbls = note.getLabels().stream().map(l -> l.getValue()).collect(toList());

        String csv = String.join(",", lbls);

        String[] headers = { "id", "value", "labels", "createdAt" };
        String[][] data = {
                { "[" + AnsiColors.ANSI_GREEN + note.getId() +
                        AnsiColors.ANSI_RESET + "]",
                        note.getValue(), csv, String.valueOf(note.getCreatedAt()) }
        };
        System.out.println(FlipTable.of(headers, data));
    }
}
