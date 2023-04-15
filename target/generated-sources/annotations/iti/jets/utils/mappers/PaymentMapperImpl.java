package iti.jets.utils.mappers;

import iti.jets.database.entities.Customer;
import iti.jets.database.entities.Payment;
import iti.jets.database.entities.Rental;
import iti.jets.database.entities.Staff;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.dtos.RentalDto;
import iti.jets.service.dtos.StaffDto;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class PaymentMapperImpl implements PaymentMapper {

    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private StaffMapper staffMapper;
    @Inject
    private RentalMapper rentalMapper;

    @Override
    public Payment toEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentDto.getId() );
        payment.setCustomer( customerMapper.toEntity( paymentDto.getCustomer() ) );
        payment.setStaff( staffMapper.toEntity( paymentDto.getStaff() ) );
        payment.setRental( rentalMapper.toEntity( paymentDto.getRental() ) );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );
        payment.setLastUpdate( paymentDto.getLastUpdate() );

        return payment;
    }

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        Integer id = null;
        CustomerDto customer = null;
        StaffDto staff = null;
        RentalDto rental = null;
        BigDecimal amount = null;
        Instant paymentDate = null;
        Instant lastUpdate = null;

        id = payment.getId();
        customer = customerMapper.toDto( payment.getCustomer() );
        staff = staffMapper.toDto( payment.getStaff() );
        rental = rentalMapper.toDto( payment.getRental() );
        amount = payment.getAmount();
        paymentDate = payment.getPaymentDate();
        lastUpdate = payment.getLastUpdate();

        PaymentDto paymentDto = new PaymentDto( id, customer, staff, rental, amount, paymentDate, lastUpdate );

        return paymentDto;
    }

    @Override
    public Payment partialUpdate(PaymentDto paymentDto, Payment payment) {
        if ( paymentDto == null ) {
            return null;
        }

        if ( paymentDto.getId() != null ) {
            payment.setId( paymentDto.getId() );
        }
        if ( paymentDto.getCustomer() != null ) {
            if ( payment.getCustomer() == null ) {
                payment.setCustomer( new Customer() );
            }
            customerMapper.partialUpdate( paymentDto.getCustomer(), payment.getCustomer() );
        }
        if ( paymentDto.getStaff() != null ) {
            if ( payment.getStaff() == null ) {
                payment.setStaff( new Staff() );
            }
            staffMapper.partialUpdate( paymentDto.getStaff(), payment.getStaff() );
        }
        if ( paymentDto.getRental() != null ) {
            if ( payment.getRental() == null ) {
                payment.setRental( new Rental() );
            }
            rentalMapper.partialUpdate( paymentDto.getRental(), payment.getRental() );
        }
        if ( paymentDto.getAmount() != null ) {
            payment.setAmount( paymentDto.getAmount() );
        }
        if ( paymentDto.getPaymentDate() != null ) {
            payment.setPaymentDate( paymentDto.getPaymentDate() );
        }
        if ( paymentDto.getLastUpdate() != null ) {
            payment.setLastUpdate( paymentDto.getLastUpdate() );
        }

        return payment;
    }
}
