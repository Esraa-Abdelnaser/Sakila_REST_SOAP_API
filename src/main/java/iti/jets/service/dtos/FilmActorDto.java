package iti.jets.service.dtos;

import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmActorId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Data
public class FilmActorDto implements Serializable {
    private final FilmActorId id;
    private final ActorDto actor;
    private final FilmDto film;
    @NotNull
    private final Instant lastUpdate;
}