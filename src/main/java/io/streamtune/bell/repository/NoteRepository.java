package io.streamtune.bell.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.streamtune.bell.entities.Note;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NoteRepository implements PanacheRepository<Note> {

    public Note findById(Long id) {
        return find("id", id).firstResult();
    }
}
