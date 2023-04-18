package iti.jets.service.dtos;

import iti.jets.database.entities.Inventory;
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
 * A DTO for the {@link Inventory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto implements Serializable {
    private Integer id;

    //    help
//    @NotNull
//    private FilmDto film;
//    @NotNull
//    private StoreDto store;
//    @NotNull
//    private StoreDto store;

    @NotNull
    private Instant lastUpdate;

    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;

}