package iti.jets.service.dtos;

import iti.jets.database.entities.Store;
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
 * A DTO for the {@link Store} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto implements Serializable {

    private Integer id;

    @NotNull
    private Instant lastUpdate;

//    @NotNull
//    private StaffDto managerStaff;

    @NotNull
    private AddressDto address;

    private List<Link> links;
}