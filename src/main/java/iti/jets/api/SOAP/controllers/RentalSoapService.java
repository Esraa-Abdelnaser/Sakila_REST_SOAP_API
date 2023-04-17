package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.RentalDto;
import iti.jets.service.impls.RentalServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class RentalSoapService {
    private RentalServicesImpl rentalServices = new RentalServicesImpl();

    public List<RentalDto> getAll() {
        List<RentalDto> listOfRentalDto = rentalServices.getAll();
        return listOfRentalDto;
    }

    public RentalDto getById(@WebParam(name = "id") Integer id) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));

        if (optionalRental.isPresent()) {
            RentalDto rentalDto = optionalRental.get();
            return rentalDto;
        } else {
            return null;
        }
    }

    public String insert(RentalDto rentalDto) {

        try {
            rentalServices.insert(rentalDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public RentalDto update(RentalDto rentalDto) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(rentalDto.getId()));

        if (optionalRental.isPresent()) {
            rentalServices.update(rentalDto);
            return rentalDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));
        try {
            if (optionalRental.isPresent()) {
                RentalDto rentalDto = rentalServices.getById(id);
                rentalServices.delete(rentalDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
