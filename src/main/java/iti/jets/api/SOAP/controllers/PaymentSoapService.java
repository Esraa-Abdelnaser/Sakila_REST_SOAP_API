package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.impls.PaymentServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class PaymentSoapService {
    private PaymentServicesImpl paymentServices = new PaymentServicesImpl();
    
    public Response getAll() {
        List<PaymentDto> listOfPaymentDto = paymentServices.getAll();
        return Response.ok(listOfPaymentDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));

        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = optionalPayment.get();
            return Response.ok(paymentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(PaymentDto paymentDto) {

        try {
            paymentServices.insert(paymentDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(PaymentDto paymentDto) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(paymentDto.getId()));

        if (optionalPayment.isPresent()) {
            paymentServices.update(paymentDto);
            return Response.ok(paymentDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));
        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = paymentServices.getById(id);
            paymentServices.delete(paymentDto);
        }
        return Response.noContent().build();
    }
}

