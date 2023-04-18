package iti.jets.service.dtos;

import iti.jets.database.entities.Film;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Film} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto implements Serializable {

    private Integer id;

    @Size(max = 128)
    @NotNull
    private String title;

    private String description;

    private Integer releaseYear;

    @NotNull
    private LanguageDto language;

    private LanguageDto originalLanguage;

    @NotNull
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

    private List<FilmCategoryDto> filmCategoryList;

    private List<FilmActorDto> filmActorList;

    private List<InventoryDto> inventoryList;

    private List<Link> links;
}