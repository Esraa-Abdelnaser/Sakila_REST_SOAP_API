package iti.jets.service.dtos;

import iti.jets.database.entities.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Actor} entity
 */
@Data
public class ActorDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @NotNull
    private final Instant lastUpdate;
}