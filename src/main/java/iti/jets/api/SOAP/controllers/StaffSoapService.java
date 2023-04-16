package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.StaffDto;
import iti.jets.service.impls.StaffServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class StaffSoapService {
    private StaffServicesImpl staffServices = new StaffServicesImpl();
    
    public Response getAll() {
        List<StaffDto> listOfStaffDto = staffServices.getAll();
        return Response.ok(listOfStaffDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));

        if (optionalStaff.isPresent()) {
            StaffDto staffDto = optionalStaff.get();
            return Response.ok(staffDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(StaffDto staffDto) {

        try {
            staffServices.insert(staffDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(StaffDto staffDto) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(staffDto.getId()));

        if (optionalStaff.isPresent()) {
            staffServices.update(staffDto);
            return Response.ok(staffDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));
        if (optionalStaff.isPresent()) {
            StaffDto staffDto = staffServices.getById(id);
            staffServices.delete(staffDto);
        }
        return Response.noContent().build();
    }
}
