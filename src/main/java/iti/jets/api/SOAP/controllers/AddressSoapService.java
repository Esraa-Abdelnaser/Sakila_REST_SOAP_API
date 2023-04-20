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
    public String getAll() {
//        List<AddressDto> listOfAddressDto = addressServices.getAll();
        return "hello ziad";
    }

    @WebMethod
    public String getById(@WebParam(name = "id") Integer id) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));

        if (optionalAddress.isPresent()) {
            AddressDto addressDto = optionalAddress.get();
            return "hello ziad";
        } else {
            return null;
        }
    }

    @WebMethod
    public String insert(AddressDto addressDto) {

        try {
            addressServices.insert(addressDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public String update(AddressDto addressDto) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(addressDto.getId()));

        if (optionalAddress.isPresent()) {
            addressServices.update(addressDto);
            return "hi ziad";
        } else {
            return null;
        }
    }


    @WebMethod
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
