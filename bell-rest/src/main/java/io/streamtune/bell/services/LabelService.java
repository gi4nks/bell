package io.streamtune.bell.services;

import java.util.List;

import io.streamtune.bell.services.dto.LabelDTO;

public interface LabelService {

    LabelDTO findById(Long id);
    LabelDTO findByValue(String value);
    List<LabelDTO> findAll();
    void delete(Long id);
    void truncateAll();

    LabelDTO create(LabelDTO labelDTO);
}
