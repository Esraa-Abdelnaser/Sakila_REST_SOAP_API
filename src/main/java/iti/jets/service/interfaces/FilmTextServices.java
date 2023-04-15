package iti.jets.service.interfaces;

import iti.jets.database.entities.FilmText;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.FilmTextDto;

import java.util.List;

public interface FilmTextServices {
    List<FilmTextDto> getAll();

    FilmTextDto getById(Integer id);

    void insert(FilmTextDto filmTextDto);

    void update(FilmTextDto filmTextDto);

    void delete(FilmTextDto filmTextDto);
}
