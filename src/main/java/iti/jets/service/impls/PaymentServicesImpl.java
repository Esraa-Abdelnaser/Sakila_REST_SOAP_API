package iti.jets.service.impls;

import iti.jets.database.entities.Payment;
import iti.jets.database.repos.impls.PaymentRepoImpl;
import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.interfaces.PaymentServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.PaymentMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class PaymentServicesImpl implements PaymentServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    PaymentRepoImpl paymentRepo = new PaymentRepoImpl(entityManager);
    PaymentMapper mapper = PaymentMapper.INSTANCE;

    @Override
    public List<PaymentDto> getAll() {
        List<Payment> listOfPayment = paymentRepo.getAll();
        List<PaymentDto> listOfPaymentDto = new ArrayList<>();
        for (Payment payment : listOfPayment) {
            listOfPaymentDto.add(mapper.toDto(payment));
        }
        return listOfPaymentDto;
    }

    @Override
    public PaymentDto getById(Integer id) {
        return mapper.toDto(paymentRepo.getById(id));
    }

    @Override
    public void insert(PaymentDto paymentDto) {
        paymentRepo.insert(mapper.toEntity(paymentDto));
    }

    @Override
    public void update(PaymentDto paymentDto) {
        paymentRepo.update(mapper.toEntity(paymentDto));
    }

    @Override
    public void delete(PaymentDto paymentDto) {
        paymentRepo.delete(mapper.toEntity(paymentDto));
    }
}
