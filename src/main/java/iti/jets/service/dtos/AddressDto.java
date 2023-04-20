package iti.jets.service.dtos;

import iti.jets.database.entities.Address;
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
 * A DTO for the {@link Address} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Size(max = 10)
    private String postalCode;

    @Size(max = 20)
    @NotNull
    private String phone;

    private Instant lastUpdate;

    private byte[] location;

    @NotNull
    private CityDto city;

    private List<Link> links;
}