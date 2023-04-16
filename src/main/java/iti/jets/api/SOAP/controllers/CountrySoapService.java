package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CountryDto;
import iti.jets.service.impls.CountryServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class CountrySoapService {
    private CountryServicesImpl countryServices = new CountryServicesImpl();
    
    public Response getAll() {
        List<CountryDto> listOfCountryDto = countryServices.getAll();
        return Response.ok(listOfCountryDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));

        if (optionalCountry.isPresent()) {
            CountryDto countryDto = optionalCountry.get();
            return Response.ok(countryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(CountryDto countryDto) {

        try {
            countryServices.insert(countryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(CountryDto countryDto) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(countryDto.getId()));

        if (optionalCountry.isPresent()) {
            countryServices.update(countryDto);
            return Response.ok(countryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));
        if (optionalCountry.isPresent()) {
            CountryDto countryDto = countryServices.getById(id);
            countryServices.delete(countryDto);
        }
        return Response.noContent().build();
    }
}
