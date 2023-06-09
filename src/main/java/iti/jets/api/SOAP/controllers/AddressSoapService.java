package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.impls.AddressServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class AddressSoapService {
    private AddressServicesImpl addressServices = new AddressServicesImpl();

    @WebMethod
    public List<AddressDto> getAllAddresses() {
        List<AddressDto> listOfAddressDto = addressServices.getAll();
        return listOfAddressDto;
    }

    @WebMethod
    public AddressDto getAddressById(@WebParam(name = "id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));

        if (optionalAddress.isPresent()) {
            AddressDto addressDto = optionalAddress.get();
            return addressDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertAddress(AddressDto addressDto) {

        try {
            addressServices.insert(addressDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public AddressDto updateAddress(AddressDto addressDto) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(addressDto.getId()));

        if (optionalAddress.isPresent()) {
            addressServices.update(addressDto);
            return addressDto;
        } else {
            return null;
        }
    }


    @WebMethod
    public String deleteAddress(@WebParam(name = "id") Integer id) {
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
