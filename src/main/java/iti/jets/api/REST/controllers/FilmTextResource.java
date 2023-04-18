package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.FilmTextDto;
import iti.jets.service.impls.FilmTextServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/filmText")
public class FilmTextResource {
    private FilmTextServicesImpl filmTextServices = new FilmTextServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<FilmTextDto> listOfFilmTextDto = filmTextServices.getAll();
        for (FilmTextDto filmTextDto : listOfFilmTextDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmTextDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfFilmTextDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));

        if (optionalFilmText.isPresent()) {
            FilmTextDto filmTextDto = optionalFilmText.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmTextDto.setLinks(Arrays.asList(self));
            return Response.ok(filmTextDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(FilmTextDto filmTextDto, @Context UriInfo uriInfo) {

        try {
            filmTextServices.insert(filmTextDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(FilmTextDto filmTextDto, @Context UriInfo uriInfo) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(filmTextDto.getId()));

        if (optionalFilmText.isPresent()) {
            filmTextServices.update(filmTextDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmTextDto.setLinks(Arrays.asList(self));
            return Response.ok(filmTextDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmTextDto> optionalFilmText = Optional.ofNullable(filmTextServices.getById(id));
        if (optionalFilmText.isPresent()) {
            FilmTextDto filmTextDto = filmTextServices.getById(id);
            filmTextServices.delete(filmTextDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmTextDto.setLinks(Arrays.asList(self));
            return Response.ok(filmTextDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
