package iti.jets.service.dtos;

import iti.jets.database.entities.Staff;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Staff} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private StoreDto store;

    @NotNull
    private Boolean active = false;

    @Size(max = 16)
    @NotNull
    private String username;

    @Size(max = 40)
    private String password;

    @NotNull
    private Instant lastUpdate;

    private List<Link> links;
}