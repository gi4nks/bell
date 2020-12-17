package io.streamtune.bell.services.models;

import java.time.Instant;
import java.util.List;

import javax.json.bind.annotation.JsonbCreator;

public class Note {
    public Long id;
    public String value;
    public List<Label> labels;
    
    public static class Label {
        public String value;
    }

    public Note() {
    }

    public Note(String value, List<Label> labels) {
        this.value = value;
        this.labels = labels;
    }

    @JsonbCreator
    public static Note of(String value, List<Label> labels) {
        return new Note(value, labels);
    }

}
