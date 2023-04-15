package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CityDto;

import java.util.List;

public interface CityServices {
    List<CityDto> getAll();

    CityDto getById(Integer id);

    void insert(CityDto cityDto);

    void update(CityDto cityDto);

    void delete(CityDto cityDto);
}
