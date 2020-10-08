package io.streamtune.bell.services.models;

import java.time.Instant;
import java.util.List;

import javax.json.bind.annotation.JsonbCreator;

public class Note {
    public Long id;
    public String value;
    public List<Label> labels;
    public Instant createdAt;

    public static class Label {
        public String value;
    }

    public Note() {
    }

    public Note(String value, List<Label> labels, Instant createdAt) {
        this.value = value;
        this.labels = labels;
        this.createdAt = createdAt;
    }

    @JsonbCreator
    public static Note of(String value, List<Label> labels, Instant createdAt) {
        return new Note(value, labels, createdAt);
    }

}
