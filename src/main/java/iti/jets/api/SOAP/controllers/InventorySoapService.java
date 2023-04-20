package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.impls.InventoryServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class InventorySoapService {
    private InventoryServicesImpl inventoryServices = new InventoryServicesImpl();

    @WebMethod
    public List<InventoryDto> getAllInventories() {
        List<InventoryDto> listOfInventoryDto = inventoryServices.getAll();
        return listOfInventoryDto;
    }

    @WebMethod
    public InventoryDto getInventoryById(@WebParam(name = "id") Integer id) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));

        if (optionalInventory.isPresent()) {
            InventoryDto inventoryDto = optionalInventory.get();
            return inventoryDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertInventory(InventoryDto inventoryDto) {

        try {
            inventoryServices.insert(inventoryDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(inventoryDto.getId()));

        if (optionalInventory.isPresent()) {
            inventoryServices.update(inventoryDto);
            return inventoryDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deleteInventory(@WebParam(name = "id") Integer id) {
        Optional<InventoryDto> optionalInventory = Optional.ofNullable(inventoryServices.getById(id));
        try {
            if (optionalInventory.isPresent()) {
                InventoryDto inventoryDto = inventoryServices.getById(id);
                inventoryServices.delete(inventoryDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
