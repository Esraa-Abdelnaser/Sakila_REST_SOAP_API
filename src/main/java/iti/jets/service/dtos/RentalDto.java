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
    private Integer id;
    @NotNull
    private Instant rentalDate;
    @NotNull
    private InventoryDto inventory;
    @NotNull
    private CustomerDto customer;
    private Instant returnDate;
    @NotNull
    private Staff staff;
    @NotNull
    private Instant lastUpdate;
}