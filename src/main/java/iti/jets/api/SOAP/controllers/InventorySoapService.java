package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.impls.InventoryServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class InventorySoapService {
    private InventoryServicesImpl inventoryServices = new InventoryServicesImpl();
    
    public Response getAll() {
        List<InventoryDto> listOfInventoryDto = inventoryServices.getAll();
        return Response.ok(listOfInventoryDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));

        if (optionalInventory.isPresent()) {
            InventoryDto inventoryDto = optionalInventory.get();
            return Response.ok(inventoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(InventoryDto inventoryDto) {

        try {
            inventoryServices.insert(inventoryDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(InventoryDto inventoryDto) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(inventoryDto.getId()));

        if (optionalInventory.isPresent()) {
            inventoryServices.update(inventoryDto);
            return Response.ok(inventoryDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));
        if (optionalInventory.isPresent()) {
            InventoryDto inventoryDto = inventoryServices.getById(id);
            inventoryServices.delete(inventoryDto);
        }
        return Response.noContent().build();
    }
}
