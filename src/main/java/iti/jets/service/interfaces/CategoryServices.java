package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.FilmDto;

import java.util.List;

public interface CategoryServices {
    List<CategoryDto> getAll();

    CategoryDto getById(Integer id);

    void insert(CategoryDto categoryDto);

    void update(CategoryDto categoryDto);

    void delete(CategoryDto categoryDto);

    List<FilmDto> getCategoryForActor(CategoryDto categoryDto);
}
