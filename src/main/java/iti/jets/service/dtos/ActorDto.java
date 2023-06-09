package iti.jets.service.dtos;

import iti.jets.database.entities.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Actor} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto implements Serializable {

    private Integer id;

    @Size(max = 45)
    @NotNull
    private String firstName;

    @Size(max = 45)
    @NotNull
    private String lastName;

    private Instant lastUpdate;

    private List<FilmActorDto> filmActorList;

    private List<Link> links;

}