package io.streamtune.bell.services;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.LabelDTO;
import io.streamtune.bell.services.dto.NoteDTO;

import java.util.List;
import java.util.Optional;

public interface LabelService {

    LabelDTO findById(Long id);
    LabelDTO findByValue(String value);
    List<LabelDTO> findAll();
    void delete(Long id);
    void truncateAll();
}
