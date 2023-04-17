package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.impls.LanguageServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class LanguageSoapService {
    private LanguageServicesImpl languageServices = new LanguageServicesImpl();

    public List<LanguageDto> getAll() {
        List<LanguageDto> listOfLanguageDto = languageServices.getAll();
        return listOfLanguageDto;
    }

    public LanguageDto getById(@WebParam(name = "id") Integer id) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));

        if (optionalLanguage.isPresent()) {
            LanguageDto languageDto = optionalLanguage.get();
            return languageDto;
        } else {
            return null;
        }
    }

    public String insert(LanguageDto languageDto) {

        try {
            languageServices.insert(languageDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public LanguageDto update(LanguageDto languageDto) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(languageDto.getId()));

        if (optionalLanguage.isPresent()) {
            languageServices.update(languageDto);
            return languageDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));
        try {
            if (optionalLanguage.isPresent()) {
                LanguageDto languageDto = languageServices.getById(id);
                languageServices.delete(languageDto);

                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
