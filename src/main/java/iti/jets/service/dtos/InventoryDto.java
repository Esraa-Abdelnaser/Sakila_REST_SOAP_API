package iti.jets.service.dtos;

import iti.jets.database.entities.Inventory;
import iti.jets.database.entities.Store;
import jakarta.validation.constraints.NotNull;
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
//    @NotNull
//    private FilmDto film;
//    @NotNull
//    private StoreDto store;
//    @NotNull
//    private StoreDto store;
    @NotNull
    private Instant lastUpdate;
    private List<RentalDto> rentalList;

}