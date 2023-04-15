package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CustomerDto;

import java.util.List;

public interface CustomerServices {
    List<CustomerDto> getAll();

    CustomerDto getById(Integer id);

    void insert(CustomerDto customerDto);

    void update(CustomerDto customerDto);

    void delete(CustomerDto customerDto);


}
