package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.impls.CategoryServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class CategorySoapService {
    private CategoryServicesImpl categoryServices = new CategoryServicesImpl();


    public Response getAll() {
        List<CategoryDto> listOfCategoryDto = categoryServices.getAll();
        return Response.ok(listOfCategoryDto).build();
    }


    public Response getById(@WebParam(name="id") Integer id) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        if (optionalCategory.isPresent()) {
            CategoryDto CategoryDto = optionalCategory.get();
            return Response.ok(CategoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

 
    public Response insert(CategoryDto CategoryDto) {

        try {
            categoryServices.insert(CategoryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }


    public Response update(CategoryDto CategoryDto) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(CategoryDto.getId()));

        if (optionalCategory.isPresent()) {
            categoryServices.update(CategoryDto);
            return Response.ok(CategoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    public Response delete(@WebParam(name="id") Integer id) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        if (optionalCategory.isPresent()) {
            CategoryDto CategoryDto = categoryServices.getById(id);
            categoryServices.delete(CategoryDto);
        }
        return Response.noContent().build();
    }
}
