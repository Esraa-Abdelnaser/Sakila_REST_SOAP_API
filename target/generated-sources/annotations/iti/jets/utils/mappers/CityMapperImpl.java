package iti.jets.utils.mappers;

import iti.jets.database.entities.City;
import iti.jets.database.entities.Country;
import iti.jets.service.dtos.CityDto;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class CityMapperImpl implements CityMapper {

    @Override
    public City toEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDto.getId() );
        city.setCity( cityDto.getCity() );
        city.setCountry( cityDto.getCountry() );
        city.setLastUpdate( cityDto.getLastUpdate() );

        return city;
    }

    @Override
    public CityDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        Integer id = null;
        String city1 = null;
        Country country = null;
        Instant lastUpdate = null;

        id = city.getId();
        city1 = city.getCity();
        country = city.getCountry();
        lastUpdate = city.getLastUpdate();

        CityDto cityDto = new CityDto( id, city1, country, lastUpdate );

        return cityDto;
    }

    @Override
    public City partialUpdate(CityDto cityDto, City city) {
        if ( cityDto == null ) {
            return null;
        }

        if ( cityDto.getId() != null ) {
            city.setId( cityDto.getId() );
        }
        if ( cityDto.getCity() != null ) {
            city.setCity( cityDto.getCity() );
        }
        if ( cityDto.getCountry() != null ) {
            city.setCountry( cityDto.getCountry() );
        }
        if ( cityDto.getLastUpdate() != null ) {
            city.setLastUpdate( cityDto.getLastUpdate() );
        }

        return city;
    }
}
