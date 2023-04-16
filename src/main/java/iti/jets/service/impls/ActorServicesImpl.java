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
        ActorMapper mapper = ActorMapper.INSTANCE;
    @Override
    public List<ActorDto> getAll() {
        List<Actor> listOfActors = actorRepoImpl.getAll();
        List<ActorDto> listOfActorDto = new ArrayList<>();
        for (Actor act: listOfActors) {
            listOfActorDto.add(mapper.toDto(act));
        }
        return listOfActorDto;
    }

    @Override
    public ActorDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(ActorDto actorDto) {
        actorRepoImpl.insert(mapper.toEntity(actorDto));

    }

    @Override
    public void update(ActorDto actorDto) {
        actorRepoImpl.update(mapper.toEntity(actorDto));
    }

    @Override
    public void delete(ActorDto actorDto) {
        actorRepoImpl.delete(mapper.toEntity(actorDto));
    }
}
