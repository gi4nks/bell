package io.streamtune.bell.services.mapper;

import io.streamtune.bell.entities.Note;
import io.streamtune.bell.services.dto.NoteDTO;
import org.mapstruct.*;

import javax.enterprise.context.ApplicationScoped;

/**
 * Mapper for the entity {@link Note} and its DTO {@link NoteDTO}.
 */
@ApplicationScoped
@Mapper(componentModel = "cdi")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NoteMapper extends EntityMapper<NoteDTO, Note> {

    NoteDTO toDto(Note note);

    @Mapping(target = "createdAt", ignore = true)
    Note toEntity(NoteDTO noteDTO);
}
