package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmActor;
import iti.jets.service.dtos.FilmActorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmActorMapper {

    FilmActorMapper INSTANCE = Mappers.getMapper( FilmActorMapper.class );
    FilmActor toEntity(FilmActorDto filmActorDto);

    FilmActorDto toDto(FilmActor filmActor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmActor partialUpdate(FilmActorDto filmActorDto, @MappingTarget FilmActor filmActor);
}