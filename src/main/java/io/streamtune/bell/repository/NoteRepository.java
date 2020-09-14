package io.streamtune.bell.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.NoteDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NoteRepository implements PanacheRepository<Note> {

    public Note findById(Long id) {
        return find("id", id).firstResult();
    }

    public Note findLast() {
        Optional<Note> note = list("order by createdAt").stream().findFirst();
        return note.isPresent() ? note.get() : null;
    }

    public List<Note> findByLabel(Label lbl) {
        return list("#Note.findByLabel", lbl);
    }
}
