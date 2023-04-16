package iti.jets.utils.mappers;

import iti.jets.database.entities.Inventory;
import iti.jets.service.dtos.InventoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface InventoryMapper {

    InventoryMapper INSTANCE = Mappers.getMapper( InventoryMapper.class );
    Inventory toEntity(InventoryDto inventoryDto);

    InventoryDto toDto(Inventory inventory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory partialUpdate(InventoryDto inventoryDto, @MappingTarget Inventory inventory);
}