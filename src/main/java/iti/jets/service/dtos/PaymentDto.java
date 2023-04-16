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
    private Integer id;
    @NotNull
    private CustomerDto customer;
    @NotNull
    private StaffDto staff;
    private RentalDto rental;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Instant paymentDate;
    private Instant lastUpdate;
}