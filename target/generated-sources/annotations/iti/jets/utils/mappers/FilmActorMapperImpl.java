package iti.jets.utils.mappers;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Film;
import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmActorId;
import iti.jets.database.entities.Language;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.FilmActorDto;
import iti.jets.service.dtos.FilmDto;
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
public class FilmActorMapperImpl implements FilmActorMapper {

    @Override
    public FilmActor toEntity(FilmActorDto filmActorDto) {
        if ( filmActorDto == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        filmActor.setId( filmActorDto.getId() );
        filmActor.setActor( actorDtoToActor( filmActorDto.getActor() ) );
        filmActor.setFilm( filmDtoToFilm( filmActorDto.getFilm() ) );
        filmActor.setLastUpdate( filmActorDto.getLastUpdate() );

        return filmActor;
    }

    @Override
    public FilmActorDto toDto(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }

        FilmActorId id = null;
        ActorDto actor = null;
        FilmDto film = null;
        Instant lastUpdate = null;

        id = filmActor.getId();
        actor = actorToActorDto( filmActor.getActor() );
        film = filmToFilmDto( filmActor.getFilm() );
        lastUpdate = filmActor.getLastUpdate();

        FilmActorDto filmActorDto = new FilmActorDto( id, actor, film, lastUpdate );

        return filmActorDto;
    }

    @Override
    public FilmActor partialUpdate(FilmActorDto filmActorDto, FilmActor filmActor) {
        if ( filmActorDto == null ) {
            return null;
        }

        if ( filmActorDto.getId() != null ) {
            filmActor.setId( filmActorDto.getId() );
        }
        if ( filmActorDto.getActor() != null ) {
            if ( filmActor.getActor() == null ) {
                filmActor.setActor( new Actor() );
            }
            actorDtoToActor1( filmActorDto.getActor(), filmActor.getActor() );
        }
        if ( filmActorDto.getFilm() != null ) {
            if ( filmActor.getFilm() == null ) {
                filmActor.setFilm( new Film() );
            }
            filmDtoToFilm1( filmActorDto.getFilm(), filmActor.getFilm() );
        }
        if ( filmActorDto.getLastUpdate() != null ) {
            filmActor.setLastUpdate( filmActorDto.getLastUpdate() );
        }

        return filmActor;
    }

    protected Actor actorDtoToActor(ActorDto actorDto) {
        if ( actorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setId( actorDto.getId() );
        actor.setFirstName( actorDto.getFirstName() );
        actor.setLastName( actorDto.getLastName() );
        actor.setLastUpdate( actorDto.getLastUpdate() );

        return actor;
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

    protected ActorDto actorToActorDto(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        Integer id = null;
        String firstName = null;
        String lastName = null;
        Instant lastUpdate = null;

        id = actor.getId();
        firstName = actor.getFirstName();
        lastName = actor.getLastName();
        lastUpdate = actor.getLastUpdate();

        ActorDto actorDto = new ActorDto( id, firstName, lastName, lastUpdate );

        return actorDto;
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

    protected void actorDtoToActor1(ActorDto actorDto, Actor mappingTarget) {
        if ( actorDto == null ) {
            return;
        }

        if ( actorDto.getId() != null ) {
            mappingTarget.setId( actorDto.getId() );
        }
        if ( actorDto.getFirstName() != null ) {
            mappingTarget.setFirstName( actorDto.getFirstName() );
        }
        if ( actorDto.getLastName() != null ) {
            mappingTarget.setLastName( actorDto.getLastName() );
        }
        if ( actorDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( actorDto.getLastUpdate() );
        }
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
