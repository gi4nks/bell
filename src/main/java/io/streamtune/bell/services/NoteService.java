package io.streamtune.bell.services;

import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.NoteDTO;

import java.util.List;

public interface NoteService {

    NoteDTO findById(Long id);
    List<NoteDTO> findAll();
    NoteDTO create(String n);
    NoteDTO create(String n, List<String> labels);
    void delete(Long id);
    void truncateAll();

    NoteDTO findLast();
}
