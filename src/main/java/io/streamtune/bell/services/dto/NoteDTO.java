package io.streamtune.bell.services.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class NoteDTO implements Serializable {
    private Long id;
    private String value;
    private List<LabelDTO> labels;
    private Date createdAt;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
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
