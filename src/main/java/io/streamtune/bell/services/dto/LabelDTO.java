package io.streamtune.bell.services.dto;

import java.io.Serializable;

public class LabelDTO implements Serializable {
    private Long id;
    private String value;

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

    @Override
    public String toString() {
        return "LabelDTO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
