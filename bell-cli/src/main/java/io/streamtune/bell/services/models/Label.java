package io.streamtune.bell.services.models;

import java.util.List;

public class Label {
    public Long id;
    public String value;

    public List<Note> notes;

    public static class Note {
        public String value;
    }
}
