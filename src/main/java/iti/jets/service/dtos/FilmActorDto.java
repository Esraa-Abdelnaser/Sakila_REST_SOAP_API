package iti.jets.service.dtos;

import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmActorId;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorDto implements Serializable {

    private FilmActorId id;

    @NotNull
    private Instant lastUpdate;

    private List<Link> links;
}