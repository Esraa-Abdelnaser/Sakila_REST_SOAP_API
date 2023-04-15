package iti.jets.database.repos.impls;

import iti.jets.database.entities.Actor;
import jakarta.persistence.EntityManager;

public class ActorRepoImpl extends GenericRepo<Integer, Actor> {

    public ActorRepoImpl(EntityManager entityManager) {
        super(entityManager, Actor.class);
    }

}
