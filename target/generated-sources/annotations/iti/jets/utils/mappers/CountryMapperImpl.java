package iti.jets.utils.mappers;

import iti.jets.database.entities.Country;
import iti.jets.service.dtos.CountryDto;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDto.getId() );
        country.setCountry( countryDto.getCountry() );
        country.setLastUpdate( countryDto.getLastUpdate() );

        return country;
    }

    @Override
    public CountryDto toDto(Country country) {
        if ( country == null ) {
            return null;
        }

        Integer id = null;
        String country1 = null;
        Instant lastUpdate = null;

        id = country.getId();
        country1 = country.getCountry();
        lastUpdate = country.getLastUpdate();

        CountryDto countryDto = new CountryDto( id, country1, lastUpdate );

        return countryDto;
    }

    @Override
    public Country partialUpdate(CountryDto countryDto, Country country) {
        if ( countryDto == null ) {
            return null;
        }

        if ( countryDto.getId() != null ) {
            country.setId( countryDto.getId() );
        }
        if ( countryDto.getCountry() != null ) {
            country.setCountry( countryDto.getCountry() );
        }
        if ( countryDto.getLastUpdate() != null ) {
            country.setLastUpdate( countryDto.getLastUpdate() );
        }

        return country;
    }
}
