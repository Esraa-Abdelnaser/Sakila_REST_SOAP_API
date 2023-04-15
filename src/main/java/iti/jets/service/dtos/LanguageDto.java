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
    private final Short id;
    @Size(max = 20)
    @NotNull
    private final String name;
    @NotNull
    private final Instant lastUpdate;
}