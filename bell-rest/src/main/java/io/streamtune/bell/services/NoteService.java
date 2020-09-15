package io.streamtune.bell.services;

import io.streamtune.bell.services.dto.NoteDTO;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    NoteDTO findById(Long id);
    List<NoteDTO> findAll();
    NoteDTO create(NoteDTO n);
    NoteDTO create(String n);
    NoteDTO create(String n, List<String> labels);
    void delete(Long id);
    void truncateAll();

    NoteDTO findLast();
    List<NoteDTO> findByLabel(String lbl);
}
