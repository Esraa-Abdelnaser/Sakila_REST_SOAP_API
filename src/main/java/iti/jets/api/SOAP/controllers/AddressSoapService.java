package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.impls.AddressServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;

@WebService
public class AddressSoapService {
    private AddressServicesImpl addressServices = new AddressServicesImpl();

    public List<AddressDto> getAll(@Context UriInfo uriInfo) {
        List<AddressDto> listOfAddressDto = addressServices.getAll();
        return listOfAddressDto;
    }

    public AddressDto getById(@WebParam(name = "id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));

        if (optionalAddress.isPresent()) {
            AddressDto addressDto = optionalAddress.get();
            return addressDto;
        } else {
            return null;
        }
    }

    public String insert(AddressDto addressDto) {

        try {
            addressServices.insert(addressDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public AddressDto update(AddressDto addressDto) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(addressDto.getId()));

        if (optionalAddress.isPresent()) {
            addressServices.update(addressDto);
            return addressDto;
        } else {
            return null;
        }
    }


    public String delete(@WebParam(name = "id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));
        try {
            if (optionalAddress.isPresent()) {
                AddressDto addressDto = addressServices.getById(id);
                addressServices.delete(addressDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
