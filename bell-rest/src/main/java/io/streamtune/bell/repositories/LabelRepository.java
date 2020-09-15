package io.streamtune.bell.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.streamtune.bell.entities.Label;

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
