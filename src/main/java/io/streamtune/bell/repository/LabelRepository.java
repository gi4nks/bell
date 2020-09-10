package io.streamtune.bell.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LabelRepository implements PanacheRepository<Label> {

    public Label findById(Long id) {
        return find("id", id).firstResult();
    }

    public Optional<Label> findByValue(String value) {
        return find("value", value).firstResultOptional();
    }
}
