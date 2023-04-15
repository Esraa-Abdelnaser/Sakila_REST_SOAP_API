package iti.jets.service.dtos;

import iti.jets.database.entities.Payment;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link Payment} entity
 */
@Data
public class PaymentDto implements Serializable {
    private final Integer id;
    @NotNull
    private final CustomerDto customer;
    @NotNull
    private final StaffDto staff;
    private final RentalDto rental;
    @NotNull
    private final BigDecimal amount;
    @NotNull
    private final Instant paymentDate;
    private final Instant lastUpdate;
}