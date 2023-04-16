package iti.jets.utils.mappers;

import iti.jets.database.entities.City;
import iti.jets.service.dtos.CityDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper( CityMapper.class );
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}