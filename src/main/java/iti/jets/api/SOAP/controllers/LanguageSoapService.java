package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.impls.LanguageServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class LanguageSoapService {
    private LanguageServicesImpl languageServices = new LanguageServicesImpl();
    
    public Response getAll() {
        List<LanguageDto> listOfLanguageDto = languageServices.getAll();
        return Response.ok(listOfLanguageDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));

        if (optionalLanguage.isPresent()) {
            LanguageDto languageDto = optionalLanguage.get();
            return Response.ok(languageDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(LanguageDto languageDto) {

        try {
            languageServices.insert(languageDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(LanguageDto languageDto) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(languageDto.getId()));

        if (optionalLanguage.isPresent()) {
            languageServices.update(languageDto);
            return Response.ok(languageDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));
        if (optionalLanguage.isPresent()) {
            LanguageDto languageDto = languageServices.getById(id);
            languageServices.delete(languageDto);
        }
        return Response.noContent().build();
    }
}
