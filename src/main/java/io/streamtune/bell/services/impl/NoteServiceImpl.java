package io.streamtune.bell.services.impl;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.repository.LabelRepository;
import io.streamtune.bell.repository.NoteRepository;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
import io.streamtune.bell.services.mapper.LabelMapper;
import io.streamtune.bell.services.mapper.NoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class NoteServiceImpl implements NoteService {
    private final Logger log = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Inject
    NoteRepository repository;

    @Inject
    LabelRepository labelRepository;

    @Inject
    NoteMapper mapper;

    @Override
    @Transactional
    public NoteDTO findById(Long id) {
        log.debug("Request to get Note : {}", id);
        return mapper.toDto(repository.findById(id));
    }

    @Override
    @Transactional
    public List<NoteDTO> findAll() {
        log.debug("Request to get all Notes");
        return repository.listAll().stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NoteDTO create(String n) {
        return this.create(n,  Collections.emptyList());
    }

    @Override
    @Transactional
    public NoteDTO create(String n, List<String> labels) {
        Note note = new Note();

        note.setValue(n);
        note.setCreatedAt(new Date());

        Set<Label> lbls = new HashSet<>();

        for (String label : labels) {
            Optional<Label> ll = labelRepository.findByValue(label);
            if (ll.isPresent())
                lbls.add(ll.get());
            else {
                Label nl = new Label();
                nl.setValue(label);
                labelRepository.persist(nl);

                lbls.add(nl);
            }
        }

        note.setLabels(lbls);
        repository.persist(note);

        return mapper.toDto(note);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Note n = repository.findById(id);
        if (n!= null) {
            repository.delete(n);
        }
    }

    @Override
    @Transactional
    public void truncateAll() {
        repository.deleteAll();
    }
}
