package iti.jets.service.dtos;

import iti.jets.database.entities.Rental;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Rental} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto implements Serializable {

    private Integer id;

    private Instant rentalDate;

    @NotNull
    private InventoryDto inventory;

    @NotNull
    private CustomerDto customer;

    private Instant returnDate;

    @NotNull
    private StaffDto staff;

    private Instant lastUpdate;

    private List<Link> links;
}