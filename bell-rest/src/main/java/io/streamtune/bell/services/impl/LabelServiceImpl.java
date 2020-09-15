package io.streamtune.bell.services.impl;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.repositories.LabelRepository;
import io.streamtune.bell.services.LabelService;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.mapper.LabelMapper;
import io.streamtune.bell.services.mapper.NoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

    @Inject
    NoteMapper noteMapper;

    @Override
    public LabelDTO findById(Long id) {
        log.debug("Request to get Label : {}", id);
        return mapper.toDto(repository.findById(id));
    }

    @Override
    @Transactional
    public List<LabelDTO> findAll() {
        log.debug("Request to get all Labels");
        return repository.listAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public void truncateAll() {

    }

    @Override
    @Transactional
    public LabelDTO create(LabelDTO labelDTO) {
        log.debug("Request to create a label");

        Label label = mapper.toEntity(labelDTO);

        repository.persist(label);

        return mapper.toDto(label);
    }

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
}
