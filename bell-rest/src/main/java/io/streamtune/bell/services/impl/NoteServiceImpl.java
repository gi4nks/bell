package io.streamtune.bell.services.impl;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.repositories.LabelRepository;
import io.streamtune.bell.repositories.NoteRepository;
import io.streamtune.bell.services.NoteService;
import io.streamtune.bell.services.dto.NoteDTO;
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
    public NoteDTO create(NoteDTO n) {
        Note note = mapper.toEntity(n);

        Set<Label> lbls = new HashSet<>();

        note.getLabels().stream().forEach(l -> {
            String label = l.getValue();
            Label nl = null;
            Optional<Label> ll = labelRepository.findByValue(label);
            if (ll.isPresent()) {
                System.out.println("I found already a label: " + label);
                nl = ll.get();
            } else {
                nl = new Label();
                nl.setValue(label);
                labelRepository.persist(nl);
            }

            lbls.add(nl);
        });

        note.setLabels(lbls);
        repository.persist(note);

        return mapper.toDto(note);
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

        Set<Label> lbls = new HashSet<>();
        for (String label : labels) {
            Label nl = null;
            Optional<Label> ll = labelRepository.findByValue(label);
            if (ll.isPresent()) {
                System.out.println("I found already a label: " + label);
                nl = ll.get();
            } else {
                nl = new Label();
                nl.setValue(label);
                labelRepository.persist(nl);
            }

            lbls.add(nl);
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
    public List<NoteDTO> findByLabel(String lbl) {
        log.debug("Request to get all notes from label {0}", lbl);
        Optional<Label> label = labelRepository.findByValue(lbl);

        if (label.isPresent()) {
            System.out.println("The label has been found");
            List<Note> notes = repository.findByLabel(label.get());

            return notes.stream()
                    .map(mapper::toDto).collect(Collectors.toList());
        }

        return Collections.EMPTY_LIST;

    }

    @Override
    @Transactional
    public void truncateAll() {
        repository.deleteAll();
    }

    @Override
    @Transactional
    public NoteDTO findLast() {
        return mapper.toDto(repository.findLast());
    }
}
