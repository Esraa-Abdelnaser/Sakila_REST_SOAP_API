package iti.jets.service.dtos;

import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmActorId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorDto implements Serializable {

    private FilmActorId id;
//    private ActorDto actor;
//    private FilmDto film;
    @NotNull
    private Instant lastUpdate;
}