package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.impls.AddressServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;

@WebService
public class AddressSoapService {
    private AddressServicesImpl addressServices = new AddressServicesImpl();

    public Response getAll(@Context UriInfo uriInfo) {
        List<AddressDto> listOfAddressDto = addressServices.getAll();
        return Response.ok(listOfAddressDto).build();
    }

    public Response getById(@WebParam(name="id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));

        if (optionalAddress.isPresent()) {
            AddressDto addressDto = optionalAddress.get();
            return Response.ok(addressDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response insert(AddressDto addressDto) {

        try {
            addressServices.insert(addressDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    public Response update(AddressDto addressDto) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(addressDto.getId()));

        if (optionalAddress.isPresent()) {
            addressServices.update(addressDto);
            return Response.ok(addressDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));
        if (optionalAddress.isPresent()) {
            AddressDto addressDto = addressServices.getById(id);
            addressServices.delete(addressDto);
        }
        return Response.noContent().build();
    }
}
