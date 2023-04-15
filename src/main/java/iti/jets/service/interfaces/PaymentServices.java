package iti.jets.service.interfaces;

import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.PaymentDto;

import java.util.List;

public interface PaymentServices {
    List<PaymentDto> getAll();

    PaymentDto getById(Integer id);

    void insert(PaymentDto paymentDto);

    void update(PaymentDto paymentDto);

    void delete(PaymentDto paymentDto);
}
