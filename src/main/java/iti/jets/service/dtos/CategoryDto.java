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
    private Integer id;
    @Size(max = 25)
    @NotNull
    private String name;
    @NotNull
    private Instant lastUpdate;
}