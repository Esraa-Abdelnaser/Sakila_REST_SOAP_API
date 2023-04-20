package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.FilmTextDto;
import iti.jets.service.impls.FilmTextServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class FilmTextSoapService {
    private FilmTextServicesImpl filmTextServices = new FilmTextServicesImpl();

    @WebMethod
    public List<FilmTextDto> getAll() {
        List<FilmTextDto> listOfFilmTextDto = filmTextServices.getAll();
        return listOfFilmTextDto;
    }

    @WebMethod
    public FilmTextDto getById(@WebParam(name = "id") Integer id) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));

        if (optionalFilmText.isPresent()) {
            FilmTextDto filmTextDto = optionalFilmText.get();
            return filmTextDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insert(FilmTextDto filmTextDto) {

        try {
            filmTextServices.insert(filmTextDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public FilmTextDto update(FilmTextDto filmTextDto) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(filmTextDto.getId()));

        if (optionalFilmText.isPresent()) {
            filmTextServices.update(filmTextDto);
            return filmTextDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String delete(@WebParam(name = "id") Integer id) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));
        try {
            if (optionalFilmText.isPresent()) {
                FilmTextDto filmTextDto = filmTextServices.getById(id);
                filmTextServices.delete(filmTextDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
