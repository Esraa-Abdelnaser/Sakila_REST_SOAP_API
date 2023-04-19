package iti.jets.service.interfaces;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.FilmDto;

import java.util.List;

public interface FilmServices {
    List<FilmDto> getAll();

    FilmDto getById(Integer id);

    void insert(FilmDto filmDto);

    void update(FilmDto filmDto);

    void delete(FilmDto filmDto);

    List<ActorDto> getActorsForFilm(FilmDto FilmDto);

    List<CategoryDto> getCategoriesForFilm(FilmDto FilmDto);
}
