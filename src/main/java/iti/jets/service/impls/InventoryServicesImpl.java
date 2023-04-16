package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Inventory;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.InventoryRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.interfaces.InventoryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.InventoryMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class InventoryServicesImpl implements InventoryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    InventoryRepoImpl actorRepoImpl = new InventoryRepoImpl(entityManager);
    InventoryMapper mapper = InventoryMapper.INSTANCE;

    @Override
    public List<InventoryDto> getAll() {
        List<Inventory> listOfInventory = actorRepoImpl.getAll();
        List<InventoryDto> listOfInventoryDto = new ArrayList<>();
        for (Inventory inventory : listOfInventory) {
            listOfInventoryDto.add(mapper.toDto(inventory));
        }
        return listOfInventoryDto;
    }

    @Override
    public InventoryDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(InventoryDto inventoryDto) {
        actorRepoImpl.insert(mapper.toEntity(inventoryDto));
    }

    @Override
    public void update(InventoryDto inventoryDto) {
        actorRepoImpl.update(mapper.toEntity(inventoryDto));
    }

    @Override
    public void delete(InventoryDto inventoryDto) {
        actorRepoImpl.delete(mapper.toEntity(inventoryDto));
    }
}
