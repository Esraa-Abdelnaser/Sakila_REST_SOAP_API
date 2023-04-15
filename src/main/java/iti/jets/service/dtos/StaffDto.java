package iti.jets.service.dtos;

import iti.jets.database.entities.Staff;
import iti.jets.database.entities.Store;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Staff} entity
 */
@Data
public class StaffDto implements Serializable {
    private final Short id;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @NotNull
    private final AddressDto address;
    private final byte[] picture;
    @Size(max = 50)
    private final String email;
    @NotNull
    private final Store store;
    @NotNull
    private final Boolean active;
    @Size(max = 16)
    @NotNull
    private final String username;
    @Size(max = 40)
    private final String password;
    @NotNull
    private final Instant lastUpdate;
}