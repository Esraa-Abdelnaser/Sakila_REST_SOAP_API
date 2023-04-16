package iti.jets.service.dtos;

import iti.jets.database.entities.FilmCategory;
import iti.jets.database.entities.FilmCategoryId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmCategory} entity
 */
@Data
public class FilmCategoryDto implements Serializable {
    private FilmCategoryId id;
    private FilmDto film;
    private CategoryDto category;
    @NotNull
    private Instant lastUpdate;
}