package iti.jets.service.dtos;

import iti.jets.database.entities.Category;
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
 * A DTO for the {@link Category} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private Integer id;
    @Size(max = 25)
    @NotNull
    private String name;

    private Instant lastUpdate;

    private List<FilmCategoryDto> filmCategoryList;

    private List<Link> links;
}