package io.streamtune.bell.services.dto;

import java.io.Serializable;
import java.util.List;

public class LabelDTO implements Serializable {
    private static final long serialVersionUID = -575571569690891925L;
    
    private Long id;
    private String value;
    private List<NoteDTO> notes;

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

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "LabelDTO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
