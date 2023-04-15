package iti.jets.service.dtos;

import iti.jets.database.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Short id;
    @Size(max = 25)
    @NotNull
    private final String name;
    @NotNull
    private final Instant lastUpdate;
}