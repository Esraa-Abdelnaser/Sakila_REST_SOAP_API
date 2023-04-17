package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.impls.CategoryServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class CategorySoapService {
    private CategoryServicesImpl categoryServices = new CategoryServicesImpl();


    public List<CategoryDto> getAll() {
        List<CategoryDto> listOfCategoryDto = categoryServices.getAll();
        return listOfCategoryDto;
    }


    public CategoryDto getById(@WebParam(name = "id") Integer id) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        if (optionalCategory.isPresent()) {
            CategoryDto CategoryDto = optionalCategory.get();
            return CategoryDto;
        } else {
            return null;
        }
    }


    public String insert(CategoryDto CategoryDto) {

        try {
            categoryServices.insert(CategoryDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public CategoryDto update(CategoryDto CategoryDto) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(CategoryDto.getId()));

        if (optionalCategory.isPresent()) {
            categoryServices.update(CategoryDto);
            return CategoryDto;
        } else {
            return null;
        }
    }


    public String delete(@WebParam(name = "id") Integer id) {
        Optional<CategoryDto> optionalCategory = Optional.ofNullable(categoryServices.getById(id));
        try {
            if (optionalCategory.isPresent()) {
                CategoryDto CategoryDto = categoryServices.getById(id);
                categoryServices.delete(CategoryDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
