package iti.jets.service.dtos;

import iti.jets.database.entities.Film;
import iti.jets.database.entities.Language;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link Film} entity
 */
@Data
public class FilmDto implements Serializable {
    private final Integer id;
    @Size(max = 128)
    @NotNull
    private final String title;
    private final String description;
    private final Integer releaseYear;
    @NotNull
    private final Language language;
    private final Language originalLanguage;
    private final Short rentalDuration;
    @NotNull
    private final BigDecimal rentalRate;
    private final Integer length;
    @NotNull
    private final BigDecimal replacementCost;
    @Size(max = 5)
    private final String rating;
    @Size(max = 54)
    private final String specialFeatures;
    @NotNull
    private final Instant lastUpdate;
}