package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.dtos.StoreDto;
import iti.jets.service.impls.StoreServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/store")
public class StoreResource {
    private StoreServicesImpl storeServices = new StoreServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<StoreDto> listOfStoreDto = storeServices.getAll();
        for (StoreDto storeDto : listOfStoreDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            storeDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfStoreDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));

        if (optionalStore.isPresent()) {
            StoreDto storeDto = optionalStore.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            storeDto.setLinks(Arrays.asList(self));
            return Response.ok(storeDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(StoreDto storeDto, @Context UriInfo uriInfo) {

        try {
            storeServices.insert(storeDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(StoreDto storeDto, @Context UriInfo uriInfo) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(storeDto.getId()));

        if (optionalStore.isPresent()) {
            storeServices.update(storeDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            storeDto.setLinks(Arrays.asList(self));
            return Response.ok(storeDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));
        if (optionalStore.isPresent()) {
            StoreDto storeDto = storeServices.getById(id);
            storeServices.delete(storeDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            storeDto.setLinks(Arrays.asList(self));
            return Response.ok(storeDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
