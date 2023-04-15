package iti.jets.service.dtos;

import iti.jets.database.entities.Inventory;
import iti.jets.database.entities.Store;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Inventory} entity
 */
@Data
public class InventoryDto implements Serializable {
    private final Integer id;
    @NotNull
    private final FilmDto film;
    @NotNull
    private final Store store;
    @NotNull
    private final Instant lastUpdate;
}