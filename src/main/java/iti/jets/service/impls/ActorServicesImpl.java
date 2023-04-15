package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.interfaces.ActorServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ActorServicesImpl implements ActorServices {

        EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl(entityManager);
    @Override
    public List<ActorDto> getAll() {
        List<Actor> listOfActors = actorRepoImpl.getAll();
        List<ActorDto> listOfActorDto = new ArrayList<>();
        ActorMapper mapper = ActorMapper.INSTANCE;
        for (Actor act: listOfActors) {
            listOfActorDto.add(mapper.toDto(act));
        }
        return listOfActorDto;
    }

    @Override
    public ActorDto getById(Integer id) {
        ActorMapper mapper = ActorMapper.INSTANCE;
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(ActorDto actorDto) {
        ActorMapper mapper = ActorMapper.INSTANCE;
        actorRepoImpl.insert(mapper.toEntity(actorDto));

    }

    @Override
    public void update(ActorDto actorDto) {
        ActorMapper mapper = ActorMapper.INSTANCE;
        actorRepoImpl.update(mapper.toEntity(actorDto));
    }

    @Override
    public void delete(ActorDto actorDto) {
        ActorMapper mapper = ActorMapper.INSTANCE;
        actorRepoImpl.delete(mapper.toEntity(actorDto));
    }
}
