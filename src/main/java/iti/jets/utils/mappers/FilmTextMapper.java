package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmText;
import iti.jets.service.dtos.FilmTextDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmTextMapper {

    FilmTextMapper INSTANCE = Mappers.getMapper( FilmTextMapper.class );
    FilmText toEntity(FilmTextDto filmTextDto);

    FilmTextDto toDto(FilmText filmText);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmText partialUpdate(FilmTextDto filmTextDto, @MappingTarget FilmText filmText);
}