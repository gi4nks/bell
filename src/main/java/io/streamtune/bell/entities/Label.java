package io.streamtune.bell.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Cacheable
public class Label implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    @FullTextField(analyzer = "labels")
    private String value;

    @ManyToMany(mappedBy = "labels")
    private Set<Note> notes = new HashSet<>();

    public Label() {
    }

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

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Label)) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(value, label.value) &&
                Objects.equals(notes, label.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, notes);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", notes=" + notes +
                '}';
    }
}
