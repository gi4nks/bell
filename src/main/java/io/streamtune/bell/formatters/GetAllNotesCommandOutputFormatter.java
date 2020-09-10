package io.streamtune.bell.formatters;

import com.jakewharton.fliptables.FlipTable;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.utils.AnsiColors;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetAllNotesCommandOutputFormatter {
    private List<NoteDTO> notes;

    public GetAllNotesCommandOutputFormatter(List<NoteDTO> notes) {
        this.notes = notes;
    }

    public void print() {
        String[] headers = { "id", "value", "labels", "createdAt" };
        String[][] data = new String[this.notes.size()][4];

        for (int i=0; i<notes.size(); i++) {
            NoteDTO note = notes.get(i);

            List<String> lbls = note.getLabels().stream().map(l -> l.getValue()).collect(toList());

            String csv = String.join(",", lbls);

            data[i][0] = "[" + AnsiColors.ANSI_GREEN + note.getId() +
                            AnsiColors.ANSI_RESET + "]";
            data[i][1] = note.getValue();
            data[i][2] = csv;
            data[i][3] = String.valueOf(note.getCreatedAt());
        }
        System.out.println(FlipTable.of(headers, data));
    }
}
