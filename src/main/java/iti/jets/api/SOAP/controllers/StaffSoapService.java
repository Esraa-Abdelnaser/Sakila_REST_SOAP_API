package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.StaffDto;
import iti.jets.service.impls.StaffServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class StaffSoapService {
    private StaffServicesImpl staffServices = new StaffServicesImpl();

    @WebMethod
    public List<StaffDto> getAllStaff() {
        List<StaffDto> listOfStaffDto = staffServices.getAll();
        return listOfStaffDto;
    }

    @WebMethod
    public StaffDto getStaffById(@WebParam(name = "id") Integer id) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));

        if (optionalStaff.isPresent()) {
            StaffDto staffDto = optionalStaff.get();
            return staffDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertStaff(StaffDto staffDto) {

        try {
            staffServices.insert(staffDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public StaffDto updateStaff(StaffDto staffDto) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(staffDto.getId()));

        if (optionalStaff.isPresent()) {
            staffServices.update(staffDto);
            return staffDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deleteStaff(@WebParam(name = "id") Integer id) {
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
