package iti.jets.service.dtos;

import iti.jets.database.entities.City;
import iti.jets.database.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link City} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {

    private Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    @NotNull
//    private CountryDto country;
//    @NotNull
    private Instant lastUpdate;
    private List<AddressDto> addressList;

//    private Integer id;
//    @Size(max = 50)
//    @NotNull
//    private String city;
//    @NotNull
//    private Integer countryId;
//    @NotNull
//    private Instant lastUpdate;
////    private List<AddressDto> addressList;

}