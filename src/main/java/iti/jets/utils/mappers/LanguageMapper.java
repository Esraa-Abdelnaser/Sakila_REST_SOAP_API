package iti.jets.utils.mappers;

import iti.jets.database.entities.Language;
import iti.jets.service.dtos.LanguageDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper( LanguageMapper.class );
    Language toEntity(LanguageDto languageDto);

    LanguageDto toDto(Language language);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Language partialUpdate(LanguageDto languageDto, @MappingTarget Language language);
}