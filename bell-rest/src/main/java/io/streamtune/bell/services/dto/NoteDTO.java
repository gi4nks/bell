package io.streamtune.bell.services.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class NoteDTO implements Serializable {
    private static final long serialVersionUID = 4110260933141170119L;
    
    private Long id;
    private String value;
    private List<LabelDTO> labels;
    private Instant createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", labels=" + labels +
                ", createdAt=" + createdAt +
                '}';
    }
}
