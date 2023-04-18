package iti.jets.api.REST.controllers;

import iti.jets.database.entities.Category;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.impls.CategoryServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;

@Path("/category")
public class CategoryResource {

    private CategoryServicesImpl categoryServices = new CategoryServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<CategoryDto> listOfCategoryDto = categoryServices.getAll();
        return Response.ok(listOfCategoryDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));

        if (optionalCategory.isPresent()) {
            CategoryDto CategoryDto = optionalCategory.get();
            return Response.ok(CategoryDto).build();
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
    public Response update(CategoryDto CategoryDto, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(CategoryDto.getId()));

        if (optionalCategory.isPresent()) {
            categoryServices.update(CategoryDto);
            return Response.ok(CategoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        if (optionalCategory.isPresent()) {
            CategoryDto CategoryDto = categoryServices.getById(id);
            categoryServices.delete(CategoryDto);
            return Response.ok(CategoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
