package iti.jets.service.dtos;

import iti.jets.database.entities.Language;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Language} entity
 */
@Data
public class LanguageDto implements Serializable {
    private Short id;
    @Size(max = 20)
    @NotNull
    private String name;
    @NotNull
    private Instant lastUpdate;
}