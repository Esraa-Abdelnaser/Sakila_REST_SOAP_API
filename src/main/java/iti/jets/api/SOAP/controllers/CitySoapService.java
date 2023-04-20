package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CityDto;
import iti.jets.service.impls.CityServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class CitySoapService {
    private CityServicesImpl cityServices = new CityServicesImpl();

    @WebMethod
    public List<CityDto> getAll() {
        List<CityDto> listOfCityDto = cityServices.getAll();
        return listOfCityDto;
    }

    @WebMethod
    public CityDto getById(@WebParam(name = "id") Integer id) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));

        if (optionalCity.isPresent()) {
            CityDto cityDto = optionalCity.get();
            return cityDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insert(CityDto cityDto) {

        try {
            cityServices.insert(cityDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public CityDto update(CityDto cityDto) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(cityDto.getId()));

        if (optionalCity.isPresent()) {
            cityServices.update(cityDto);
            return cityDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String delete(@WebParam(name = "id") Integer id) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));
        try {
            if (optionalCity.isPresent()) {
                CityDto cityDto = cityServices.getById(id);
                cityServices.delete(cityDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
