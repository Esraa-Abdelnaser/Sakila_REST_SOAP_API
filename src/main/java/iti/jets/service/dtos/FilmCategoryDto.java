package iti.jets.service.dtos;

import iti.jets.database.entities.FilmCategory;
import iti.jets.database.entities.FilmCategoryId;
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
 * A DTO for the {@link FilmCategory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategoryDto implements Serializable {

    private FilmCategoryId id;

    @NotNull
    private Instant lastUpdate;

    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;
}