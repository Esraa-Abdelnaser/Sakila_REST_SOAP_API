package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.dtos.StaffDto;
import iti.jets.service.impls.StaffServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/staff")
public class StaffResource {
    private StaffServicesImpl staffServices = new StaffServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<StaffDto> listOfStaffDto = staffServices.getAll();
        for (StaffDto staffDto : listOfStaffDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            staffDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfStaffDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));

        if (optionalStaff.isPresent()) {
            StaffDto staffDto = optionalStaff.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            staffDto.setLinks(Arrays.asList(self));
            return Response.ok(staffDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(StaffDto staffDto, @Context UriInfo uriInfo) {

        try {
            staffServices.insert(staffDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(StaffDto staffDto, @Context UriInfo uriInfo) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(staffDto.getId()));
        if (optionalStaff.isPresent()) {
            staffServices.update(staffDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            staffDto.setLinks(Arrays.asList(self));
            return Response.ok(staffDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<StaffDto> optionalStaff = Optional.ofNullable(staffServices.getById(id));
        if (optionalStaff.isPresent()) {
            StaffDto staffDto = staffServices.getById(id);
            staffServices.delete(staffDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            staffDto.setLinks(Arrays.asList(self));
            return Response.ok(staffDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
