package iti.jets.service.dtos;

import iti.jets.database.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Country} entity
 */
@Data
public class CountryDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String country;
    @NotNull
    private Instant lastUpdate;
}