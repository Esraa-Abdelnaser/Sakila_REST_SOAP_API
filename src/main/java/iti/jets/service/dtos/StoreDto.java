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
    private final Short id;
    @NotNull
    private final StaffDto managerStaff;
    @NotNull
    private final AddressDto address;
    @NotNull
    private final Instant lastUpdate;
}