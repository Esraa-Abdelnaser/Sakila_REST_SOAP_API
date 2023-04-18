package iti.jets.service.dtos;

import iti.jets.database.entities.FilmText;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link FilmText} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmTextDto implements Serializable {

    private Integer id;

    @Size(max = 255)
    @NotNull
    private String title;

    private String description;

    private List<Link> links;
}