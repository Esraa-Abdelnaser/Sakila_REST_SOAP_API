package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.impls.ActorServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class ActorSoapService {
    private ActorServicesImpl actorServices = new ActorServicesImpl();

    public List<ActorDto> getAll() {
        List<ActorDto> listOfActorDto = actorServices.getAll();
        return listOfActorDto;
    }

    public ActorDto getById(@WebParam(name = "id") Integer id) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return actorDto;
        } else {
            return null;
        }
    }

    public String insert(ActorDto actorDto) {

        try {
            actorServices.insert(actorDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ActorDto update(ActorDto actorDto) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(actorDto.getId()));
        if (optionalActor.isPresent()) {
            actorServices.update(actorDto);
            return actorDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        try {
            if (optionalActor.isPresent()) {
                ActorDto actorDto = actorServices.getById(id);
                actorServices.delete(actorDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
