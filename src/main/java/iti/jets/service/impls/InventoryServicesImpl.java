package iti.jets.service.impls;

import iti.jets.database.entities.Inventory;
import iti.jets.database.repos.impls.InventoryRepoImpl;
import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.interfaces.InventoryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.InventoryMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class InventoryServicesImpl implements InventoryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    InventoryRepoImpl inventoryRepo = new InventoryRepoImpl(entityManager);
    InventoryMapper mapper = InventoryMapper.INSTANCE;

    @Override
    public List<InventoryDto> getAll() {
        List<Inventory> listOfInventory = inventoryRepo.getAll();
        List<InventoryDto> listOfInventoryDto = new ArrayList<>();
        for (Inventory inventory : listOfInventory) {
            listOfInventoryDto.add(mapper.toDto(inventory));
        }
        return listOfInventoryDto;
    }

    @Override
    public InventoryDto getById(Integer id) {
        return mapper.toDto(inventoryRepo.getById(id));
    }

    @Override
    public void insert(InventoryDto inventoryDto) {
        inventoryRepo.insert(mapper.toEntity(inventoryDto));
    }

    @Override
    public void update(InventoryDto inventoryDto) {
        inventoryRepo.update(mapper.toEntity(inventoryDto));
    }

    @Override
    public void delete(InventoryDto inventoryDto) {
        inventoryRepo.delete(mapper.toEntity(inventoryDto));
    }
}
