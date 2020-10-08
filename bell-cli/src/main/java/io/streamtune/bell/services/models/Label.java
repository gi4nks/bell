package io.streamtune.bell.services.models;

import java.util.List;

import javax.json.bind.annotation.JsonbCreator;

public class Label {
    public Long id;
    public String value;

    public List<Note> notes;

    public static class Note {
        public String value;
    }

    public Label(String value, List<Note> notes) {
        this.value = value;
        this.notes = notes;
    }

    @JsonbCreator
    public static Label of(String value, List<Note> notes) {
        return new Label(value, notes);
    }

}
