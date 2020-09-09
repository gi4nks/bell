package io.streamtune.bell.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.streamtune.bell.entities.Label;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LabelRepository implements PanacheRepository<Label> {

    public Optional<Label> findByValue(String value) {
        return find("value", value).firstResultOptional();
    }
}
