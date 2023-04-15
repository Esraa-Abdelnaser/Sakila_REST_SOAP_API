package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CountryDto;

import java.util.List;

public interface CountryServices {
    List<CountryDto> getAll();

    CountryDto getById(Integer id);

    void insert(CountryDto countryDto);

    void update(CountryDto countryDto);

    void delete(CountryDto countryDto);
}
