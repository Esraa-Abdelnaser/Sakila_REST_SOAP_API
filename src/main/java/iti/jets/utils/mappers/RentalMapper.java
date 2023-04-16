package iti.jets.utils.mappers;

import iti.jets.database.entities.Rental;
import iti.jets.service.dtos.RentalDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface RentalMapper {

    RentalMapper INSTANCE = Mappers.getMapper( RentalMapper.class );
    Rental toEntity(RentalDto rentalDto);

    RentalDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalDto rentalDto, @MappingTarget Rental rental);
}