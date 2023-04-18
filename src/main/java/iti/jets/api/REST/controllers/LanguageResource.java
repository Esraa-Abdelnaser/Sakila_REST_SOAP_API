package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.impls.LanguageServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/language")
public class LanguageResource {
    private LanguageServicesImpl languageServices = new LanguageServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<LanguageDto> listOfLanguageDto = languageServices.getAll();
        for (LanguageDto languageDto : listOfLanguageDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            languageDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfLanguageDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));

        if (optionalLanguage.isPresent()) {
            LanguageDto languageDto = optionalLanguage.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            languageDto.setLinks(Arrays.asList(self));
            return Response.ok(languageDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(LanguageDto languageDto, @Context UriInfo uriInfo) {

        try {
            languageServices.insert(languageDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(LanguageDto languageDto, @Context UriInfo uriInfo) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(languageDto.getId()));

        if (optionalLanguage.isPresent()) {
            languageServices.update(languageDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            languageDto.setLinks(Arrays.asList(self));
            return Response.ok(languageDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<LanguageDto> optionalLanguage = Optional.ofNullable(languageServices.getById(id));
        if (optionalLanguage.isPresent()) {
            LanguageDto languageDto = languageServices.getById(id);
            languageServices.delete(languageDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            languageDto.setLinks(Arrays.asList(self));
            return Response.ok(languageDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
