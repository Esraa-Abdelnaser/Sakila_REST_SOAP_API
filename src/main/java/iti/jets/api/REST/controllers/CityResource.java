package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CityDto;
import iti.jets.service.impls.CityServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/city")
public class CityResource {
    private CityServicesImpl cityServices = new CityServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<CityDto> listOfCityDto = cityServices.getAll();
        for (CityDto cityDto : listOfCityDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            cityDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfCityDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));

        if (optionalCity.isPresent()) {
            CityDto cityDto = optionalCity.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            cityDto.setLinks(Arrays.asList(self));
            return Response.ok(cityDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CityDto cityDto, @Context UriInfo uriInfo) {

        try {
            cityServices.insert(cityDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CityDto cityDto, @Context UriInfo uriInfo) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(cityDto.getId()));

        if (optionalCity.isPresent()) {
            cityServices.update(cityDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            cityDto.setLinks(Arrays.asList(self));
            return Response.ok(cityDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CityDto> optionalCity = Optional.ofNullable(cityServices.getById(id));
        if (optionalCity.isPresent()) {
            CityDto cityDto = cityServices.getById(id);
            cityServices.delete(cityDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            cityDto.setLinks(Arrays.asList(self));
            return Response.ok(cityDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
