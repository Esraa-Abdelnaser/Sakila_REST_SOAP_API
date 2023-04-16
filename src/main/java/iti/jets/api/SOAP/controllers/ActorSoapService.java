package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.impls.ActorServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class ActorSoapService {
    private ActorServicesImpl actorServices = new ActorServicesImpl();

    public Response getAll() {
        List<ActorDto> listOfActorDto = actorServices.getAll();
        return Response.ok(listOfActorDto).build();
    }

    public Response getById(@WebParam(name="id") Integer id) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return Response.ok(actorDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response insert(ActorDto actorDto) {

        try {
            actorServices.insert(actorDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    public Response update(ActorDto actorDto) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(actorDto.getId()));
        if (optionalActor.isPresent()) {
            actorServices.update(actorDto);
            return Response.ok(actorDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response delete(@WebParam(name="id") Integer id) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = actorServices.getById(id);
            actorServices.delete(actorDto);
        }
        return Response.noContent().build();
    }
}
