package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.StoreDto;
import iti.jets.service.impls.StoreServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class StoreSoapService {
    private StoreServicesImpl storeServices = new StoreServicesImpl();

    public List<StoreDto> getAll() {
        List<StoreDto> listOfStoreDto = storeServices.getAll();
        return listOfStoreDto;
    }

    public StoreDto getById(@WebParam(name = "id") Integer id) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));

        if (optionalStore.isPresent()) {
            StoreDto storeDto = optionalStore.get();
            return storeDto;
        } else {
            return null;
        }
    }

    public String insert(StoreDto storeDto) {

        try {
            storeServices.insert(storeDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public StoreDto update(StoreDto storeDto) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(storeDto.getId()));

        if (optionalStore.isPresent()) {
            storeServices.update(storeDto);
            return storeDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<StoreDto> optionalStore = Optional.ofNullable(storeServices.getById(id));
        try {
            if (optionalStore.isPresent()) {
                StoreDto storeDto = storeServices.getById(id);
                storeServices.delete(storeDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
