package iti.jets.utils.mappers;

import iti.jets.database.entities.FilmText;
import iti.jets.service.dtos.FilmTextDto;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T01:38:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
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

        FilmTextDto filmTextDto = new FilmTextDto();

        filmTextDto.setId( filmText.getId() );
        filmTextDto.setTitle( filmText.getTitle() );
        filmTextDto.setDescription( filmText.getDescription() );

        return filmTextDto;
    }

    @Override
    public FilmText partialUpdate(FilmTextDto filmTextDto, FilmText filmText) {
        if ( filmTextDto == null ) {
            return filmText;
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
