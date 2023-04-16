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
    private Integer id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @NotNull
    private AddressDto address;
    private byte[] picture;
    @Size(max = 50)
    private String email;
    @NotNull
    private Store store;
    @NotNull
    private Boolean active;
    @Size(max = 16)
    @NotNull
    private String username;
    @Size(max = 40)
    private String password;
    @NotNull
    private Instant lastUpdate;
}