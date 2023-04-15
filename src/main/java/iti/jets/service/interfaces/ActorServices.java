package iti.jets.service.interfaces;

import iti.jets.service.dtos.ActorDto;

import java.util.List;

public interface ActorServices {

    List<ActorDto> getAll();

    ActorDto getById(Integer id);

    void insert(ActorDto actorDto);

    void update(ActorDto actorDto);

    void delete(ActorDto actorDto);

}
