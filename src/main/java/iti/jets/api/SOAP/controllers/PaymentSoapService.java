package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.impls.PaymentServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class PaymentSoapService {
    private PaymentServicesImpl paymentServices = new PaymentServicesImpl();

    public List<PaymentDto> getAll() {
        List<PaymentDto> listOfPaymentDto = paymentServices.getAll();
        return listOfPaymentDto;
    }

    public PaymentDto getById(@WebParam(name = "id") Integer id) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(id));

        if (optionalPayment.isPresent()) {
            PaymentDto paymentDto = optionalPayment.get();
            return paymentDto;
        } else {
            return null;
        }
    }

    public String insert(PaymentDto paymentDto) {

        try {
            paymentServices.insert(paymentDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public PaymentDto update(PaymentDto paymentDto) {
        Optional<PaymentDto> optionalPayment = Optional.ofNullable(paymentServices.getById(paymentDto.getId()));

        if (optionalPayment.isPresent()) {
            paymentServices.update(paymentDto);
            return paymentDto;
        } else {
            return null;
        }
    }

    public String delete(@WebParam(name = "id") Integer id) {
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

