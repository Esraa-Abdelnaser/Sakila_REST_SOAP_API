package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.ActorDto;
import iti.jets.service.impls.ActorServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Optional;

@Path("/actor")
public class ActorResource {
    private ActorServicesImpl ActorServices = new ActorServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<ActorDto> listOfActorDto = ActorServices.getAll();
        return Response.ok(listOfActorDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(ActorServices.getById(id));

        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return Response.ok(actorDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(ActorDto actorDto, @Context UriInfo uriInfo) {

        try {
            ActorServices.insert(actorDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(ActorDto actorDto, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(ActorServices.getById(actorDto.getId()));

        if (optionalActor.isPresent()) {
            ActorDto existingActor = optionalActor.get();
            existingActor.setFirstName(actorDto.getFirstName());
            existingActor.setLastName(actorDto.getLastName());
            existingActor.setLastUpdate(actorDto.getLastUpdate());
            ActorServices.update(existingActor);
            return Response.ok(existingActor).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(ActorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = ActorServices.getById(id);
            ActorServices.delete(actorDto);
        }
        return Response.noContent().build();
    }


}
