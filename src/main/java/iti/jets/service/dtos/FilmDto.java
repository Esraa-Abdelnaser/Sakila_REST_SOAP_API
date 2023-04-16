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
    private Integer id;
    @Size(max = 128)
    @NotNull
    private String title;
    private String description;
    private Integer releaseYear;
    @NotNull
    private Language language;
    private Language originalLanguage;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
    @Size(max = 5)
    private String rating;
    @Size(max = 54)
    private String specialFeatures;
    @NotNull
    private Instant lastUpdate;
}