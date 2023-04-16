package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Store;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.StoreRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.StoreDto;
import iti.jets.service.interfaces.StoreServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.StoreMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class StoreServicesImpl implements StoreServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    StoreRepoImpl actorRepoImpl = new StoreRepoImpl(entityManager);
    StoreMapper mapper = StoreMapper.INSTANCE;

    @Override
    public List<StoreDto> getAll() {
        List<Store> listOfStore = actorRepoImpl.getAll();
        List<StoreDto> listOfStoreDto = new ArrayList<>();
        for (Store act: listOfStore) {
            listOfStoreDto.add(mapper.toDto(act));
        }
        return listOfStoreDto;
    }

    @Override
    public StoreDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(StoreDto storeDto) {
        actorRepoImpl.insert(mapper.toEntity(storeDto));
    }

    @Override
    public void update(StoreDto storeDto) {
        actorRepoImpl.update(mapper.toEntity(storeDto));
    }

    @Override
    public void delete(StoreDto storeDto) {
        actorRepoImpl.delete(mapper.toEntity(storeDto));
    }
}
