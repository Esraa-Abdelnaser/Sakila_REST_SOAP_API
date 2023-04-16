package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmCategory;
import iti.jets.service.dtos.FilmCategoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface FilmCategoryMapper {

    FilmCategoryMapper INSTANCE = Mappers.getMapper( FilmCategoryMapper.class );
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);

    FilmCategoryDto toDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
}