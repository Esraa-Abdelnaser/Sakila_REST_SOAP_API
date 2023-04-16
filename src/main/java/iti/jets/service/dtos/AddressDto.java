package iti.jets.service.dtos;

import iti.jets.database.entities.Address;
import iti.jets.database.entities.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String address;
    @Size(max = 50)
    private String address2;
    @Size(max = 20)
    @NotNull
    private String district;
    @NotNull
    private City city;
    @Size(max = 10)
    private String postalCode;
    @Size(max = 20)
    @NotNull
    private String phone;
    @NotNull
    private Instant lastUpdate;
}