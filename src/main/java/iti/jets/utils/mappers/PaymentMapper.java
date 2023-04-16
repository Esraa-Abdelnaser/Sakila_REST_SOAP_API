package iti.jets.utils.mappers;

import iti.jets.database.entities.Payment;
import iti.jets.service.dtos.PaymentDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {CustomerMapper.class, StaffMapper.class, RentalMapper.class})
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper( PaymentMapper.class );
    Payment toEntity(PaymentDto paymentDto);

    PaymentDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentDto paymentDto, @MappingTarget Payment payment);
}