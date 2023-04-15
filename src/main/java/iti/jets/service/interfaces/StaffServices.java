package iti.jets.service.interfaces;

import iti.jets.database.entities.Staff;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.StaffDto;

import java.util.List;

public interface StaffServices {
    List<StaffDto> getAll();

    StaffDto getById(Integer id);

    void insert(StaffDto staffDto);

    void update(StaffDto staffDto);

    void delete(StaffDto staffDto);
}
