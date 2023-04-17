package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.StaffDto;
import iti.jets.service.impls.StaffServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class StaffSoapService {
    private StaffServicesImpl staffServices = new StaffServicesImpl();

    public List<StaffDto> getAll() {
        List<StaffDto> listOfStaffDto = staffServices.getAll();
        return listOfStaffDto;
    }

    public StaffDto getById(@WebParam(name = "id") Integer id) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));

        if (optionalStaff.isPresent()) {
            StaffDto staffDto = optionalStaff.get();
            return staffDto;
        } else {
            return null;
        }
    }

    public String insert(StaffDto staffDto) {

        try {
            staffServices.insert(staffDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public StaffDto update(StaffDto staffDto) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(staffDto.getId()));

        if (optionalStaff.isPresent()) {
            staffServices.update(staffDto);
            return staffDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));
        try {
            if (optionalStaff.isPresent()) {
                StaffDto staffDto = staffServices.getById(id);
                staffServices.delete(staffDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
