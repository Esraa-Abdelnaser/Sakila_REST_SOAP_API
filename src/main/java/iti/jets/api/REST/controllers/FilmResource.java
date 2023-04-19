package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.impls.FilmServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/film")
public class FilmResource {
    private FilmServicesImpl filmServices = new FilmServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<FilmDto> listOfFilmDto = filmServices.getAll();
        for (FilmDto filmDto : listOfFilmDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfFilmDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));

        if (optionalFilm.isPresent()) {
            FilmDto filmDto = optionalFilm.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
            return Response.ok(filmDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("actorsofFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorsForFilm(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));

        if (optionalFilm.isPresent()) {
            FilmDto filmDto = optionalFilm.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
            return Response.ok(filmServices.getActorsForFilm(filmDto)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("categoriesOfFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoriesForFilm(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));
        if (optionalFilm.isPresent()) {
            FilmDto filmDto = optionalFilm.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
            return Response.ok(filmServices.getCategoriesForFilm(filmDto)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(FilmDto filmDto, @Context UriInfo uriInfo) {

        try {
            filmServices.insert(filmDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(FilmDto filmDto, @Context UriInfo uriInfo) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(filmDto.getId()));

        if (optionalFilm.isPresent()) {
            filmServices.update(filmDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
            return Response.ok(filmDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<FilmDto> optionalFilm = Optional.ofNullable(filmServices.getById(id));
        if (optionalFilm.isPresent()) {
            FilmDto filmDto = filmServices.getById(id);
            filmServices.delete(filmDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            filmDto.setLinks(Arrays.asList(self));
            return Response.ok(filmDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
