package iti.jets.api.REST.controllers;

import iti.jets.database.entities.Category;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.impls.CategoryServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/category")
public class CategoryResource {

    private CategoryServicesImpl categoryServices = new CategoryServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<CategoryDto> listOfCategoryDto = categoryServices.getAll();
        for (CategoryDto categoryDto : listOfCategoryDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            categoryDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfCategoryDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));

        if (optionalCategory.isPresent()) {
            CategoryDto categoryDto = optionalCategory.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            categoryDto.setLinks(Arrays.asList(self));
            return Response.ok(categoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("categoryOfActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getfilmsForCategory(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalActor = Optional.ofNullable(categoryServices.getById(id));

        if (optionalActor.isPresent()) {
            CategoryDto categoryDto = optionalActor.get();
            return Response.ok(categoryServices.getCategoryForActor(categoryDto)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CategoryDto CategoryDto, @Context UriInfo uriInfo) {

        try {
            categoryServices.insert(CategoryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CategoryDto categoryDto, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(categoryDto.getId()));

        if (optionalCategory.isPresent()) {
            categoryServices.update(categoryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            categoryDto.setLinks(Arrays.asList(self));
            return Response.ok(categoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        if (optionalCategory.isPresent()) {
            CategoryDto categoryDto = categoryServices.getById(id);
            categoryServices.delete(categoryDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            categoryDto.setLinks(Arrays.asList(self));
            return Response.ok(categoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
