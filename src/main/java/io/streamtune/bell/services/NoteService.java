package io.streamtune.bell.services;

import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.NoteDTO;

import java.util.List;

public interface NoteService {

    public NoteDTO findById(Long id);
    public List<NoteDTO> findAll();
    public NoteDTO create(String n);
    public NoteDTO create(String n, List<String> labels);
    public void delete(Long id);
    public void truncateAll();
}
