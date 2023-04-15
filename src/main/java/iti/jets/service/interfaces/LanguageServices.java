package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.LanguageDto;

import java.util.List;

public interface LanguageServices {
    List<LanguageDto> getAll();

    LanguageDto getById(Integer id);

    void insert(LanguageDto languageDto);

    void update(LanguageDto languageDto);

    void delete(LanguageDto languageDto);
}
