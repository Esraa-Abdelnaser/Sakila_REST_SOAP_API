package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.StoreDto;

import java.util.List;

public interface StoreServices {
    List<StoreDto> getAll();

    StoreDto getById(Integer id);

    void insert(StoreDto storeDto);

    void update(StoreDto storeDto);

    void delete(StoreDto storeDto);
}
