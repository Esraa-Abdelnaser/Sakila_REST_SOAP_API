package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.impls.PaymentServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class PaymentSoapService {
    private PaymentServicesImpl paymentServices = new PaymentServicesImpl();

    @WebMethod
    public List<PaymentDto> getAllPayments() {
        List<PaymentDto> listOfPaymentDto = paymentServices.getAll();
        return listOfPaymentDto;
    }

    @WebMethod
    public PaymentDto getPaymentById(@WebParam(name = "id") Integer id) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));

        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = optionalPayment.get();
            return paymentDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertPayment(PaymentDto paymentDto) {

        try {
            paymentServices.insert(paymentDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public PaymentDto updatePayment(PaymentDto paymentDto) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(paymentDto.getId()));

        if (optionalPayment.isPresent()) {
            paymentServices.update(paymentDto);
            return paymentDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deletePayment(@WebParam(name = "id") Integer id) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));
        try {
            if (optionalPayment.isPresent()) {
                PaymentDto paymentDto = paymentServices.getById(id);
                paymentServices.delete(paymentDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

