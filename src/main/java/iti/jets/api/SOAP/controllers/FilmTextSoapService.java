package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.FilmTextDto;
import iti.jets.service.impls.FilmTextServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class FilmTextSoapService {
    private FilmTextServicesImpl filmTextServices = new FilmTextServicesImpl();

    public Response getAll() {
        List<FilmTextDto> listOfFilmTextDto = filmTextServices.getAll();
        return Response.ok(listOfFilmTextDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));

        if (optionalFilmText.isPresent()) {
            FilmTextDto filmTextDto = optionalFilmText.get();
            return Response.ok(filmTextDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(FilmTextDto filmTextDto) {

        try {
            filmTextServices.insert(filmTextDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(FilmTextDto filmTextDto) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(filmTextDto.getId()));

        if (optionalFilmText.isPresent()) {
            filmTextServices.update(filmTextDto);
            return Response.ok(filmTextDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));
        if (optionalFilmText.isPresent()) {
            FilmTextDto filmTextDto = filmTextServices.getById(id);
            filmTextServices.delete(filmTextDto);
        }
        return Response.noContent().build();
    }
}
