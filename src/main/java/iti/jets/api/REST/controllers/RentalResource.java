package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.dtos.RentalDto;
import iti.jets.service.impls.RentalServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/rental")
public class RentalResource {
    private RentalServicesImpl rentalServices = new RentalServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<RentalDto> listOfRentalDto = rentalServices.getAll();
        for (RentalDto rentalDto : listOfRentalDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            rentalDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfRentalDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));

        if (optionalRental.isPresent()) {
            RentalDto rentalDto = optionalRental.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            rentalDto.setLinks(Arrays.asList(self));
            return Response.ok(rentalDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(RentalDto rentalDto, @Context UriInfo uriInfo) {

        try {
            rentalServices.insert(rentalDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(RentalDto rentalDto, @Context UriInfo uriInfo) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(rentalDto.getId()));

        if (optionalRental.isPresent()) {
            rentalServices.update(rentalDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            rentalDto.setLinks(Arrays.asList(self));
            return Response.ok(rentalDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<RentalDto> optionalRental = Optional.ofNullable(rentalServices.getById(id));
        if (optionalRental.isPresent()) {
            RentalDto rentalDto = rentalServices.getById(id);
            rentalServices.delete(rentalDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            rentalDto.setLinks(Arrays.asList(self));
            return Response.ok(rentalDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
