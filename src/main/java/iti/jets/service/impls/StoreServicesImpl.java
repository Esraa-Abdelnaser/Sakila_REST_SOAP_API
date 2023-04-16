package iti.jets.service.impls;

import iti.jets.database.entities.Store;
import iti.jets.database.repos.impls.StoreRepoImpl;
import iti.jets.service.dtos.StoreDto;
import iti.jets.service.interfaces.StoreServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.StoreMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StoreServicesImpl implements StoreServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    StoreRepoImpl storeRepo = new StoreRepoImpl(entityManager);
    StoreMapper mapper = StoreMapper.INSTANCE;

    @Override
    public List<StoreDto> getAll() {
        List<Store> listOfStore = storeRepo.getAll();
        List<StoreDto> listOfStoreDto = new ArrayList<>();
        for (Store act: listOfStore) {
            listOfStoreDto.add(mapper.toDto(act));
        }
        return listOfStoreDto;
    }

    @Override
    public StoreDto getById(Integer id) {
        return mapper.toDto(storeRepo.getById(id));
    }

    @Override
    public void insert(StoreDto storeDto) {
        storeRepo.insert(mapper.toEntity(storeDto));
    }

    @Override
    public void update(StoreDto storeDto) {
        storeRepo.update(mapper.toEntity(storeDto));
    }

    @Override
    public void delete(StoreDto storeDto) {
        storeRepo.delete(mapper.toEntity(storeDto));
    }
}
