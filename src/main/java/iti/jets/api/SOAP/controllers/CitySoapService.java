package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CityDto;
import iti.jets.service.impls.CityServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class CitySoapService {
    private CityServicesImpl cityServices = new CityServicesImpl();
    
    public Response getAll() {
        List<CityDto> listOfCityDto = cityServices.getAll();
        return Response.ok(listOfCityDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));

        if (optionalCity.isPresent()) {
            CityDto cityDto = optionalCity.get();
            return Response.ok(cityDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(CityDto cityDto) {

        try {
            cityServices.insert(cityDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(CityDto cityDto) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(cityDto.getId()));

        if (optionalCity.isPresent()) {
            cityServices.update(cityDto);
            return Response.ok(cityDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));
        if (optionalCity.isPresent()) {
            CityDto cityDto = cityServices.getById(id);
            cityServices.delete(cityDto);
        }
        return Response.noContent().build();
    }
}
