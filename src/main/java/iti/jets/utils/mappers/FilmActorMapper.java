package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmActorId;
import iti.jets.service.dtos.FilmActorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {FilmActorMapper.class, ActorMapper.class, FilmMapper.class})
public interface FilmActorMapper {

    FilmActorMapper INSTANCE = Mappers.getMapper(FilmActorMapper.class);

    FilmActor toEntity(FilmActorDto filmActorDto);

    FilmActorDto toDto(FilmActor filmActor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActor partialUpdate(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);

    FilmActorId toEntity1(FilmActorId filmActorId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActorId partialUpdate1(FilmActorId filmActor, @MappingTarget FilmActorId filmActorId);

    FilmActor toEntity2(FilmActorDto filmActorDto);

    FilmActorDto toDto1(FilmActor filmActor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActor partialUpdate2(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);
}