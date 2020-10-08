package io.streamtune.bell.services;

import java.util.List;

import io.streamtune.bell.services.dto.NoteDTO;

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
