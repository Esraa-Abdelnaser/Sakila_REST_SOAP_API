package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.StoreDto;
import iti.jets.service.impls.StoreServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class StoreSoapService {
    private StoreServicesImpl storeServices = new StoreServicesImpl();
    
    public Response getAll() {
        List<StoreDto> listOfStoreDto = storeServices.getAll();
        return Response.ok(listOfStoreDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));

        if (optionalStore.isPresent()) {
            StoreDto storeDto = optionalStore.get();
            return Response.ok(storeDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(StoreDto storeDto) {

        try {
            storeServices.insert(storeDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(StoreDto storeDto) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(storeDto.getId()));

        if (optionalStore.isPresent()) {
            storeServices.update(storeDto);
            return Response.ok(storeDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));
        if (optionalStore.isPresent()) {
            StoreDto storeDto = storeServices.getById(id);
            storeServices.delete(storeDto);
        }
        return Response.noContent().build();
    }
}
