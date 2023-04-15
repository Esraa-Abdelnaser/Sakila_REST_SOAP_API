package iti.jets.database.repos.impls;

import iti.jets.database.entities.Language;
import jakarta.persistence.EntityManager;

public class LanguageRepoImpl extends GenericRepo<Integer, Language> {

    public LanguageRepoImpl(EntityManager entityManager) {
        super(entityManager, Language.class);
    }

}