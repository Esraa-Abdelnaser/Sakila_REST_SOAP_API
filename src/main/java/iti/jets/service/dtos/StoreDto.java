package iti.jets.service.dtos;

import iti.jets.database.entities.Store;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Store} entity
 */
@Data
public class StoreDto implements Serializable {
    private Short id;
    @NotNull
    private StaffDto managerStaff;
    @NotNull
    private AddressDto address;
    @NotNull
    private Instant lastUpdate;
}