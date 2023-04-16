package iti.jets.service.dtos;

import iti.jets.database.entities.Language;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Language} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto implements Serializable {
    private Integer id;
    @Size(max = 20)
    @NotNull
    private String name;
    @NotNull
    private Instant lastUpdate;
    private List<FilmDto> filmList;
}