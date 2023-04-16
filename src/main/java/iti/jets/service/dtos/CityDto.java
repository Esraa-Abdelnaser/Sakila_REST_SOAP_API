package iti.jets.service.dtos;

import iti.jets.database.entities.City;
import iti.jets.database.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    @NotNull
    private Country country;
    @NotNull
    private Instant lastUpdate;
}