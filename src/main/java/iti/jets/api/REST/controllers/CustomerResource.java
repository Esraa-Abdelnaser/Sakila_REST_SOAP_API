package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.impls.CustomerServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Path("/customer")
public class CustomerResource {

    private CustomerServicesImpl customerServices = new CustomerServicesImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<CustomerDto> listOfCustomerDto = customerServices.getAll();
        for (CustomerDto customerDto : listOfCustomerDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            customerDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfCustomerDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));

        if (optionalCustomer.isPresent()) {
            CustomerDto customerDto = optionalCustomer.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            customerDto.setLinks(Arrays.asList(self));
            return Response.ok(customerDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CustomerDto customerDto, @Context UriInfo uriInfo) {

        try {
            customerServices.insert(customerDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CustomerDto customerDto, @Context UriInfo uriInfo) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(customerDto.getId()));

        if (optionalCustomer.isPresent()) {
            customerServices.update(customerDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            customerDto.setLinks(Arrays.asList(self));
            return Response.ok(customerDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));
        if (optionalCustomer.isPresent()) {
            CustomerDto customerDto = customerServices.getById(id);
            customerServices.delete(customerDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            customerDto.setLinks(Arrays.asList(self));
            return Response.ok(customerDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
