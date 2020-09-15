package io.streamtune.bell.services.models;

import java.time.Instant;
import java.util.List;

public class Note {
    public Long id;
    public String value;
    public List<Label> labels;
    public Instant createdAt;

    public static class Label {
        public String value;
    }
}
