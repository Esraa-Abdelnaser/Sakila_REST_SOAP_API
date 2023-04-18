package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CountryDto;
import iti.jets.service.impls.CountryServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/country")
public class CountryResource {

    private CountryServicesImpl countryServices = new CountryServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<CountryDto> listOfCountryDto = countryServices.getAll();
        for (CountryDto countryDto : listOfCountryDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            countryDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfCountryDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));

        if (optionalCountry.isPresent()) {
            CountryDto countryDto = optionalCountry.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            countryDto.setLinks(Arrays.asList(self));
            return Response.ok(countryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CountryDto countryDto, @Context UriInfo uriInfo) {

        try {
            countryServices.insert(countryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CountryDto countryDto, @Context UriInfo uriInfo) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(countryDto.getId()));

        if (optionalCountry.isPresent()) {
            countryServices.update(countryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            countryDto.setLinks(Arrays.asList(self));
            return Response.ok(countryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CountryDto> optionalCountry = Optional.ofNullable(countryServices.getById(id));
        if (optionalCountry.isPresent()) {
            CountryDto countryDto = countryServices.getById(id);
            countryServices.delete(countryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            countryDto.setLinks(Arrays.asList(self));
            return Response.ok(countryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
