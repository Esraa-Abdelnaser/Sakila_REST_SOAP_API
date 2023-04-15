package iti.jets.utils.mappers;

import iti.jets.database.entities.Film;
import iti.jets.database.entities.Inventory;
import iti.jets.database.entities.Language;
import iti.jets.database.entities.Store;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.dtos.InventoryDto;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public Inventory toEntity(InventoryDto inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( inventoryDto.getId() );
        inventory.setFilm( filmDtoToFilm( inventoryDto.getFilm() ) );
        inventory.setStore( inventoryDto.getStore() );
        inventory.setLastUpdate( inventoryDto.getLastUpdate() );

        return inventory;
    }

    @Override
    public InventoryDto toDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        Integer id = null;
        FilmDto film = null;
        Store store = null;
        Instant lastUpdate = null;

        id = inventory.getId();
        film = filmToFilmDto( inventory.getFilm() );
        store = inventory.getStore();
        lastUpdate = inventory.getLastUpdate();

        InventoryDto inventoryDto = new InventoryDto( id, film, store, lastUpdate );

        return inventoryDto;
    }

    @Override
    public Inventory partialUpdate(InventoryDto inventoryDto, Inventory inventory) {
        if ( inventoryDto == null ) {
            return null;
        }

        if ( inventoryDto.getId() != null ) {
            inventory.setId( inventoryDto.getId() );
        }
        if ( inventoryDto.getFilm() != null ) {
            if ( inventory.getFilm() == null ) {
                inventory.setFilm( new Film() );
            }
            filmDtoToFilm1( inventoryDto.getFilm(), inventory.getFilm() );
        }
        if ( inventoryDto.getStore() != null ) {
            inventory.setStore( inventoryDto.getStore() );
        }
        if ( inventoryDto.getLastUpdate() != null ) {
            inventory.setLastUpdate( inventoryDto.getLastUpdate() );
        }

        return inventory;
    }

    protected Film filmDtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setId( filmDto.getId() );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setLanguage( filmDto.getLanguage() );
        film.setOriginalLanguage( filmDto.getOriginalLanguage() );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        film.setLastUpdate( filmDto.getLastUpdate() );

        return film;
    }

    protected FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        Integer id = null;
        String title = null;
        String description = null;
        Integer releaseYear = null;
        Language language = null;
        Language originalLanguage = null;
        Short rentalDuration = null;
        BigDecimal rentalRate = null;
        Integer length = null;
        BigDecimal replacementCost = null;
        String rating = null;
        String specialFeatures = null;
        Instant lastUpdate = null;

        id = film.getId();
        title = film.getTitle();
        description = film.getDescription();
        releaseYear = film.getReleaseYear();
        language = film.getLanguage();
        originalLanguage = film.getOriginalLanguage();
        rentalDuration = film.getRentalDuration();
        rentalRate = film.getRentalRate();
        length = film.getLength();
        replacementCost = film.getReplacementCost();
        rating = film.getRating();
        specialFeatures = film.getSpecialFeatures();
        lastUpdate = film.getLastUpdate();

        FilmDto filmDto = new FilmDto( id, title, description, releaseYear, language, originalLanguage, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate );

        return filmDto;
    }

    protected void filmDtoToFilm1(FilmDto filmDto, Film mappingTarget) {
        if ( filmDto == null ) {
            return;
        }

        if ( filmDto.getId() != null ) {
            mappingTarget.setId( filmDto.getId() );
        }
        if ( filmDto.getTitle() != null ) {
            mappingTarget.setTitle( filmDto.getTitle() );
        }
        if ( filmDto.getDescription() != null ) {
            mappingTarget.setDescription( filmDto.getDescription() );
        }
        if ( filmDto.getReleaseYear() != null ) {
            mappingTarget.setReleaseYear( filmDto.getReleaseYear() );
        }
        if ( filmDto.getLanguage() != null ) {
            mappingTarget.setLanguage( filmDto.getLanguage() );
        }
        if ( filmDto.getOriginalLanguage() != null ) {
            mappingTarget.setOriginalLanguage( filmDto.getOriginalLanguage() );
        }
        if ( filmDto.getRentalDuration() != null ) {
            mappingTarget.setRentalDuration( filmDto.getRentalDuration() );
        }
        if ( filmDto.getRentalRate() != null ) {
            mappingTarget.setRentalRate( filmDto.getRentalRate() );
        }
        if ( filmDto.getLength() != null ) {
            mappingTarget.setLength( filmDto.getLength() );
        }
        if ( filmDto.getReplacementCost() != null ) {
            mappingTarget.setReplacementCost( filmDto.getReplacementCost() );
        }
        if ( filmDto.getRating() != null ) {
            mappingTarget.setRating( filmDto.getRating() );
        }
        if ( filmDto.getSpecialFeatures() != null ) {
            mappingTarget.setSpecialFeatures( filmDto.getSpecialFeatures() );
        }
        if ( filmDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( filmDto.getLastUpdate() );
        }
    }
}
