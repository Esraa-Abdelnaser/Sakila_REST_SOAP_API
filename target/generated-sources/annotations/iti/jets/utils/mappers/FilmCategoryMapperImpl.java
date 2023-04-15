package iti.jets.utils.mappers;

import iti.jets.database.entities.Category;
import iti.jets.database.entities.Film;
import iti.jets.database.entities.FilmCategory;
import iti.jets.database.entities.FilmCategoryId;
import iti.jets.database.entities.Language;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.FilmCategoryDto;
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
public class FilmCategoryMapperImpl implements FilmCategoryMapper {

    @Override
    public FilmCategory toEntity(FilmCategoryDto filmCategoryDto) {
        if ( filmCategoryDto == null ) {
            return null;
        }

        FilmCategory filmCategory = new FilmCategory();

        filmCategory.setId( filmCategoryDto.getId() );
        filmCategory.setFilm( filmDtoToFilm( filmCategoryDto.getFilm() ) );
        filmCategory.setCategory( categoryDtoToCategory( filmCategoryDto.getCategory() ) );
        filmCategory.setLastUpdate( filmCategoryDto.getLastUpdate() );

        return filmCategory;
    }

    @Override
    public FilmCategoryDto toDto(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return null;
        }

        FilmCategoryId id = null;
        FilmDto film = null;
        CategoryDto category = null;
        Instant lastUpdate = null;

        id = filmCategory.getId();
        film = filmToFilmDto( filmCategory.getFilm() );
        category = categoryToCategoryDto( filmCategory.getCategory() );
        lastUpdate = filmCategory.getLastUpdate();

        FilmCategoryDto filmCategoryDto = new FilmCategoryDto( id, film, category, lastUpdate );

        return filmCategoryDto;
    }

    @Override
    public FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, FilmCategory filmCategory) {
        if ( filmCategoryDto == null ) {
            return null;
        }

        if ( filmCategoryDto.getId() != null ) {
            filmCategory.setId( filmCategoryDto.getId() );
        }
        if ( filmCategoryDto.getFilm() != null ) {
            if ( filmCategory.getFilm() == null ) {
                filmCategory.setFilm( new Film() );
            }
            filmDtoToFilm1( filmCategoryDto.getFilm(), filmCategory.getFilm() );
        }
        if ( filmCategoryDto.getCategory() != null ) {
            if ( filmCategory.getCategory() == null ) {
                filmCategory.setCategory( new Category() );
            }
            categoryDtoToCategory1( filmCategoryDto.getCategory(), filmCategory.getCategory() );
        }
        if ( filmCategoryDto.getLastUpdate() != null ) {
            filmCategory.setLastUpdate( filmCategoryDto.getLastUpdate() );
        }

        return filmCategory;
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

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setLastUpdate( categoryDto.getLastUpdate() );

        return category;
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

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Short id = null;
        String name = null;
        Instant lastUpdate = null;

        id = category.getId();
        name = category.getName();
        lastUpdate = category.getLastUpdate();

        CategoryDto categoryDto = new CategoryDto( id, name, lastUpdate );

        return categoryDto;
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

    protected void categoryDtoToCategory1(CategoryDto categoryDto, Category mappingTarget) {
        if ( categoryDto == null ) {
            return;
        }

        if ( categoryDto.getId() != null ) {
            mappingTarget.setId( categoryDto.getId() );
        }
        if ( categoryDto.getName() != null ) {
            mappingTarget.setName( categoryDto.getName() );
        }
        if ( categoryDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( categoryDto.getLastUpdate() );
        }
    }
}
