package iti.jets.database.repos.impls;

import iti.jets.database.entities.FilmText;
import jakarta.persistence.EntityManager;

public class FilmTextRepoImpl extends GenericRepo<Integer, FilmText> {

    public FilmTextRepoImpl(EntityManager entityManager) {
        super(entityManager, FilmText.class);
    }

}