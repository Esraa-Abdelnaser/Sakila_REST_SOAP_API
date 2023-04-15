package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.RentalDto;

import java.util.List;

public interface RentalServices {
    List<RentalDto> getAll();

    RentalDto getById(Integer id);

    void insert(RentalDto rentalDto);

    void update(RentalDto rentalDto);

    void delete(RentalDto rentalDto);
}
