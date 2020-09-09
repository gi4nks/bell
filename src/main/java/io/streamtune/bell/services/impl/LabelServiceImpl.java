package io.streamtune.bell.services.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.repository.LabelRepository;
import io.streamtune.bell.repository.NoteRepository;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.mapper.LabelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class LabelServiceImpl implements LabelService {
    private final Logger log = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Inject
    LabelRepository repository;

    @Inject
    LabelMapper mapper;

    @Override
    @Transactional
    public LabelDTO findByValue(String value) {
        log.debug("Request to get Label : {}", value);
        Optional<Label> l = repository.findByValue(value);

        LabelDTO lbl = null;
        if (l.isPresent())
            lbl = mapper.toDto(l.get());

        return lbl;
    }

    @Override
    @Transactional
    public List<LabelDTO> findAll() {
        log.debug("Request to get all Labels");
        return repository.listAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void truncateAll() {

    }
}
