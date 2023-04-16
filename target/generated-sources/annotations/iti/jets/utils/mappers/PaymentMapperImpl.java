package iti.jets.utils.mappers;

import iti.jets.database.entities.Customer;
import iti.jets.database.entities.Payment;
import iti.jets.database.entities.Rental;
import iti.jets.database.entities.Staff;
import iti.jets.service.dtos.PaymentDto;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T01:37:37+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
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

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId( payment.getId() );
        paymentDto.setCustomer( customerMapper.toDto( payment.getCustomer() ) );
        paymentDto.setStaff( staffMapper.toDto( payment.getStaff() ) );
        paymentDto.setRental( rentalMapper.toDto( payment.getRental() ) );
        paymentDto.setAmount( payment.getAmount() );
        paymentDto.setPaymentDate( payment.getPaymentDate() );
        paymentDto.setLastUpdate( payment.getLastUpdate() );

        return paymentDto;
    }

    @Override
    public Payment partialUpdate(PaymentDto paymentDto, Payment payment) {
        if ( paymentDto == null ) {
            return payment;
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
