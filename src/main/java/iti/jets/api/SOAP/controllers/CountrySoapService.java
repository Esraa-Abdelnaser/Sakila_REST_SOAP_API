package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CountryDto;
import iti.jets.service.impls.CountryServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class CountrySoapService {
    private CountryServicesImpl countryServices = new CountryServicesImpl();

    @WebMethod
    public List<CountryDto> getAllCountries() {
        List<CountryDto> listOfCountryDto = countryServices.getAll();
        return listOfCountryDto;
    }

    @WebMethod
    public CountryDto getCountryById(@WebParam(name = "id") Integer id) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));

        if (optionalCountry.isPresent()) {
            CountryDto countryDto = optionalCountry.get();
            return countryDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertCountry(CountryDto countryDto) {

        try {
            countryServices.insert(countryDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public CountryDto updateCountry(CountryDto countryDto) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(countryDto.getId()));

        if (optionalCountry.isPresent()) {
            countryServices.update(countryDto);
            return countryDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deleteCountry(@WebParam(name = "id") Integer id) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));
        try {
            if (optionalCountry.isPresent()) {
                CountryDto countryDto = countryServices.getById(id);
                countryServices.delete(countryDto);
                return "success";
            }
            return "failed";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
