package iti.jets.utils.mappers;

import iti.jets.database.entities.Language;
import iti.jets.service.dtos.LanguageDto;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public Language toEntity(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setId( languageDto.getId() );
        language.setName( languageDto.getName() );
        language.setLastUpdate( languageDto.getLastUpdate() );

        return language;
    }

    @Override
    public LanguageDto toDto(Language language) {
        if ( language == null ) {
            return null;
        }

        Short id = null;
        String name = null;
        Instant lastUpdate = null;

        id = language.getId();
        name = language.getName();
        lastUpdate = language.getLastUpdate();

        LanguageDto languageDto = new LanguageDto( id, name, lastUpdate );

        return languageDto;
    }

    @Override
    public Language partialUpdate(LanguageDto languageDto, Language language) {
        if ( languageDto == null ) {
            return null;
        }

        if ( languageDto.getId() != null ) {
            language.setId( languageDto.getId() );
        }
        if ( languageDto.getName() != null ) {
            language.setName( languageDto.getName() );
        }
        if ( languageDto.getLastUpdate() != null ) {
            language.setLastUpdate( languageDto.getLastUpdate() );
        }

        return language;
    }
}
