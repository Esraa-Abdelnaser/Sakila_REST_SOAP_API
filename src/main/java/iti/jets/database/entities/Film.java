package iti.jets.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 128)
    @NotNull
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @NotNull
    @Column(name = "rental_duration", columnDefinition = "TINYINT UNSIGNED not null")
    private Short rentalDuration;

    @NotNull
    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal rentalRate;

    @Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
    private Integer length;

    @NotNull
    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private BigDecimal replacementCost;


    @Size(max = 5)
    @Column(name = "rating", length = 5)
    private String rating;

    @Size(max = 54)
    @Column(name = "special_features", length = 54)
    private String specialFeatures;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film", fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategoryList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film", fetch = FetchType.LAZY)
    private List<FilmActor> filmActorList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
    private List<Inventory> inventoryList;

}