package iti.jets.utils.mappers;

import iti.jets.database.entities.Store;
import iti.jets.service.dtos.StoreDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper( StoreMapper.class );
    Store toEntity(StoreDto storeDto);

    StoreDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreDto storeDto, @MappingTarget Store store);
}