package io.streamtune.bell.services.mapper;

import io.streamtune.bell.entities.Label;
import io.streamtune.bell.services.dto.LabelDTO;
import org.mapstruct.*;

import javax.enterprise.context.ApplicationScoped;

/**
 * Mapper for the entity {@link Label} and its DTO {@link LabelDTO}.
 */
@ApplicationScoped
@Mapper(componentModel = "cdi")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LabelMapper extends EntityMapper<LabelDTO, Label> {

    LabelDTO toDto(Label lbl);
    Label toEntity(LabelDTO lblDTO);
}
