package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.InventoryDto;

import java.util.List;

public interface InventoryServices {
    List<InventoryDto> getAll();

    InventoryDto getById(Integer id);

    void insert(InventoryDto inventoryDto);

    void update(InventoryDto inventoryDto);

    void delete(InventoryDto inventoryDto);
}
