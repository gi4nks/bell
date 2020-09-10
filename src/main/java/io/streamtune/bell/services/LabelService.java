package io.streamtune.bell.services;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    public LabelDTO findByValue(String value);
    public List<LabelDTO> findAll();
    public void delete(Long id);
    public void truncateAll();

    List<NoteDTO> findByLabel(String lbl);
}
