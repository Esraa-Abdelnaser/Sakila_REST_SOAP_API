package iti.jets.utils.mappers;

import iti.jets.database.entities.Country;
import iti.jets.service.dtos.CountryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper( CountryMapper.class );
    Country toEntity(CountryDto countryDto);

    CountryDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);
}