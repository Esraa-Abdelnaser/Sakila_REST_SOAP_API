package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.impls.InventoryServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/inventory")
public class InventoryResource {
    private InventoryServicesImpl inventoryServices = new InventoryServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<InventoryDto> listOfInventoryDto = inventoryServices.getAll();
        for (InventoryDto inventoryDto : listOfInventoryDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            inventoryDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfInventoryDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));

        if (optionalInventory.isPresent()) {
            InventoryDto inventoryDto = optionalInventory.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            inventoryDto.setLinks(Arrays.asList(self));
            return Response.ok(inventoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(InventoryDto inventoryDto, @Context UriInfo uriInfo) {

        try {
            inventoryServices.insert(inventoryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(InventoryDto inventoryDto, @Context UriInfo uriInfo) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(inventoryDto.getId()));

        if (optionalInventory.isPresent()) {
            inventoryServices.update(inventoryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            inventoryDto.setLinks(Arrays.asList(self));
            return Response.ok(inventoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));
        if (optionalInventory.isPresent()) {
            InventoryDto inventoryDto = inventoryServices.getById(id);
            inventoryServices.delete(inventoryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            inventoryDto.setLinks(Arrays.asList(self));
            return Response.ok(inventoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
