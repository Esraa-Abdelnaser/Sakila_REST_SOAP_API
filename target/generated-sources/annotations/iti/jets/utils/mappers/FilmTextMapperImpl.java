package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmText;
import iti.jets.service.dtos.FilmTextDto;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class FilmTextMapperImpl implements FilmTextMapper {

    @Override
    public FilmText toEntity(FilmTextDto filmTextDto) {
        if ( filmTextDto == null ) {
            return null;
        }

        FilmText filmText = new FilmText();

        filmText.setId( filmTextDto.getId() );
        filmText.setTitle( filmTextDto.getTitle() );
        filmText.setDescription( filmTextDto.getDescription() );

        return filmText;
    }

    @Override
    public FilmTextDto toDto(FilmText filmText) {
        if ( filmText == null ) {
            return null;
        }

        Short id = null;
        String title = null;
        String description = null;

        id = filmText.getId();
        title = filmText.getTitle();
        description = filmText.getDescription();

        FilmTextDto filmTextDto = new FilmTextDto( id, title, description );

        return filmTextDto;
    }

    @Override
    public FilmText partialUpdate(FilmTextDto filmTextDto, FilmText filmText) {
        if ( filmTextDto == null ) {
            return null;
        }

        if ( filmTextDto.getId() != null ) {
            filmText.setId( filmTextDto.getId() );
        }
        if ( filmTextDto.getTitle() != null ) {
            filmText.setTitle( filmTextDto.getTitle() );
        }
        if ( filmTextDto.getDescription() != null ) {
            filmText.setDescription( filmTextDto.getDescription() );
        }

        return filmText;
    }
}
