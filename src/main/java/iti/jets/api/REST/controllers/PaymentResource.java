package iti.jets.api.REST.controllers;

import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.impls.PaymentServicesImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/payment")
public class PaymentResource {
    private PaymentServicesImpl paymentServices = new PaymentServicesImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context UriInfo uriInfo) {
        List<PaymentDto> listOfPaymentDto = paymentServices.getAll();
        for (PaymentDto paymentDto : listOfPaymentDto) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            paymentDto.setLinks(Arrays.asList(self));
        }
        return Response.ok(listOfPaymentDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));

        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = optionalPayment.get();
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            paymentDto.setLinks(Arrays.asList(self));
            return Response.ok(paymentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(PaymentDto paymentDto, @Context UriInfo uriInfo) {

        try {
            paymentServices.insert(paymentDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PaymentDto paymentDto, @Context UriInfo uriInfo) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(paymentDto.getId()));

        if (optionalPayment.isPresent()) {
            paymentServices.update(paymentDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            paymentDto.setLinks(Arrays.asList(self));
            return Response.ok(paymentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));
        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = paymentServices.getById(id);
            paymentServices.delete(paymentDto);
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            paymentDto.setLinks(Arrays.asList(self));
            return Response.ok(paymentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
