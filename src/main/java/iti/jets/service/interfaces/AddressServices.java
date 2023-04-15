package iti.jets.service.interfaces;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.AddressDto;

import java.util.List;

public interface AddressServices {
    List<AddressDto> getAll();

    AddressDto getById(Integer id);

    void insert(AddressDto addressDto);

    void update(AddressDto addressDto);

    void delete(AddressDto addressDto);
}
