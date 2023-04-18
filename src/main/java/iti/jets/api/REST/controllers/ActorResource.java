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
    private ActorServicesImpl actorServices = new ActorServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<ActorDto> listOfActorDto = actorServices.getAll();
        return Response.ok(listOfActorDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));

        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return Response.ok(actorDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("filmsOfActor/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getfilmsForActor(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));

        if (optionalActor.isPresent()) {
            ActorDto actorDto = optionalActor.get();
            return Response.ok(actorServices.getfilmsForActor(actorDto)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(ActorDto actorDto, @Context UriInfo uriInfo) {

        try {
            actorServices.insert(actorDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(ActorDto actorDto, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(actorDto.getId()));

        if (optionalActor.isPresent()) {
            actorServices.update(actorDto);
            return Response.ok(actorDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<ActorDto> optionalActor = Optional.ofNullable(actorServices.getById(id));
        if (optionalActor.isPresent()) {
            ActorDto actorDto = actorServices.getById(id);
            actorServices.delete(actorDto);
        }
        return Response.noContent().build();
    }
}
