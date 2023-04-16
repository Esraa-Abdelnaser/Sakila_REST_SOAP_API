package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.FilmDto;
import iti.jets.service.impls.FilmServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class FilmSoapService {
    private FilmServicesImpl filmServices = new FilmServicesImpl();
    
    public Response getAll() {
        List<FilmDto> listOfFilmDto = filmServices.getAll();
        return Response.ok(listOfFilmDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));

        if (optionalFilm.isPresent()) {
            FilmDto filmDto = optionalFilm.get();
            return Response.ok(filmDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(FilmDto filmDto) {

        try {
            filmServices.insert(filmDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(FilmDto filmDto) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(filmDto.getId()));

        if (optionalFilm.isPresent()) {
            filmServices.update(filmDto);
            return Response.ok(filmDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));
        if (optionalFilm.isPresent()) {
            FilmDto filmDto = filmServices.getById(id);
            filmServices.delete(filmDto);
        }
        return Response.noContent().build();
    }
}
