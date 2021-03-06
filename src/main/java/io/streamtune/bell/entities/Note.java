package io.streamtune.bell.entities;

import org.hibernate.annotations.BatchSize;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@Cacheable
@NamedQuery(name = "Note.truncate", query = "DELETE FROM Note")
@NamedQuery(name = "Note.findAll", query = "SELECT c FROM Note c ORDER by c.createdAt DESC")
@NamedQuery(name = "Note.findByLabel", query = "SELECT n FROM Note n WHERE ?1 member of n.labels ORDER BY n.createdAt DESC")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    @FullTextField(analyzer = "notes")
    @KeywordField(name = "notes_sort", sortable = Sortable.YES, normalizer = "sort")
    private String value;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @ManyToMany()
    @JoinTable(name = "notes_labels", joinColumns = {
            @JoinColumn(name = "note_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "label_id", referencedColumnName = "id") })
    @IndexedEmbedded
    @BatchSize(size = 20)
    private Set<Label> labels = new HashSet<>();

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(value, note.value) && Objects
                .equals(createdAt, note.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, createdAt);
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", value='" + value + '\'' + ", createdAt=" + createdAt + '}';
    }
}
