package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.impls.ActorServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class ActorSoapService {
    private ActorServicesImpl actorServices = new ActorServicesImpl();

    @WebMethod
    public List<ActorDto> getAllActors() {
        List<ActorDto> listOfActorDto = actorServices.getAll();
        return listOfActorDto;
    }

    @WebMethod
    public ActorDto getActorById(@WebParam(name = "id") Integer id) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return actorDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertActor(ActorDto actorDto) {

        try {
            actorServices.insert(actorDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public ActorDto updateActor(ActorDto actorDto) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(actorDto.getId()));
        if (optionalActor.isPresent()) {
            actorServices.update(actorDto);
            return actorDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deleteActor(@WebParam(name = "id") Integer id) {
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
