package iti.jets.database.repos.impls;

import iti.jets.database.entities.Film;
import jakarta.persistence.EntityManager;

public class FilmRepoImpl extends GenericRepo<Integer, Film> {

    public FilmRepoImpl(EntityManager entityManager) {
        super(entityManager, Film.class);
    }

}
