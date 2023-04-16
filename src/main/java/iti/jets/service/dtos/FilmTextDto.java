package iti.jets.service.dtos;

import iti.jets.database.entities.FilmText;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
}