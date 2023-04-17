package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.FilmDto;
import iti.jets.service.impls.FilmServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class FilmSoapService {
    private FilmServicesImpl filmServices = new FilmServicesImpl();

    public List<FilmDto> getAll() {
        List<FilmDto> listOfFilmDto = filmServices.getAll();
        return listOfFilmDto;
    }

    public FilmDto getById(@WebParam(name = "id") Integer id) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));

        if (optionalFilm.isPresent()) {
            FilmDto filmDto = optionalFilm.get();
            return filmDto;
        } else {
            return null;
        }
    }

    public String insert(FilmDto filmDto) {

        try {
            filmServices.insert(filmDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public FilmDto update(FilmDto filmDto) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(filmDto.getId()));

        if (optionalFilm.isPresent()) {
            filmServices.update(filmDto);
            return filmDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));
        try {
            if (optionalFilm.isPresent()) {
                FilmDto filmDto = filmServices.getById(id);
                filmServices.delete(filmDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
