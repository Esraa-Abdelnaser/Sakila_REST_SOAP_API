package iti.jets.service.dtos;

import iti.jets.database.entities.FilmCategory;
import iti.jets.database.entities.FilmCategoryId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmCategory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategoryDto implements Serializable {
    private FilmCategoryId id;
    private FilmDto film;
    private CategoryDto category;
    @NotNull
    private Instant lastUpdate;
}