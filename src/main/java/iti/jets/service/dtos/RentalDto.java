package iti.jets.service.dtos;

import iti.jets.database.entities.Rental;
import iti.jets.database.entities.Staff;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Rental} entity
 */
@Data
public class RentalDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Instant rentalDate;
    @NotNull
    private final InventoryDto inventory;
    @NotNull
    private final CustomerDto customer;
    private final Instant returnDate;
    @NotNull
    private final Staff staff;
    @NotNull
    private final Instant lastUpdate;
}