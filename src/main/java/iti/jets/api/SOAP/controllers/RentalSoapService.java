package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.RentalDto;
import iti.jets.service.impls.RentalServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class RentalSoapService {
    private RentalServicesImpl rentalServices = new RentalServicesImpl();
    
    public Response getAll() {
        List<RentalDto> listOfRentalDto = rentalServices.getAll();
        return Response.ok(listOfRentalDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));

        if (optionalRental.isPresent()) {
            RentalDto rentalDto = optionalRental.get();
            return Response.ok(rentalDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(RentalDto rentalDto) {

        try {
            rentalServices.insert(rentalDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(RentalDto rentalDto) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(rentalDto.getId()));

        if (optionalRental.isPresent()) {
            rentalServices.update(rentalDto);
            return Response.ok(rentalDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));
        if (optionalRental.isPresent()) {
            RentalDto rentalDto = rentalServices.getById(id);
            rentalServices.delete(rentalDto);
        }
        return Response.noContent().build();
    }
}
