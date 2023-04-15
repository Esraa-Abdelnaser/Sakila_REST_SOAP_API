package iti.jets.utils.mappers;

import iti.jets.database.entities.Actor;
import iti.jets.service.dtos.ActorDto;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class ActorMapperImpl implements ActorMapper {

    @Override
    public Actor toEntity(ActorDto actorDto) {
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

    @Override
    public ActorDto toDto(Actor actor) {
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

    @Override
    public Actor partialUpdate(ActorDto actorDto, Actor actor) {
        if ( actorDto == null ) {
            return null;
        }

        if ( actorDto.getId() != null ) {
            actor.setId( actorDto.getId() );
        }
        if ( actorDto.getFirstName() != null ) {
            actor.setFirstName( actorDto.getFirstName() );
        }
        if ( actorDto.getLastName() != null ) {
            actor.setLastName( actorDto.getLastName() );
        }
        if ( actorDto.getLastUpdate() != null ) {
            actor.setLastUpdate( actorDto.getLastUpdate() );
        }

        return actor;
    }
}
