package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.impls.AddressServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;

@Path("/address")
public class AddressResource {

    private AddressServicesImpl addressServices = new AddressServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<AddressDto> listOfAddressDto = addressServices.getAll();
        return Response.ok(listOfAddressDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));

        if (optionalAddress.isPresent()) {
            AddressDto addressDto = optionalAddress.get();
            return Response.ok(addressDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(AddressDto addressDto, @Context UriInfo uriInfo) {

        try {
            addressServices.insert(addressDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(AddressDto addressDto, @Context UriInfo uriInfo) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(addressDto.getId()));

        if (optionalAddress.isPresent()) {
            addressServices.update(addressDto);
            return Response.ok(addressDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<AddressDto> optionalAddress = Optional.ofNullable(addressServices.getById(id));
        if (optionalAddress.isPresent()) {
            AddressDto addressDto = addressServices.getById(id);
            addressServices.delete(addressDto);
        }
        return Response.noContent().build();
    }
}
