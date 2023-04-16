package iti.jets.database.repos.impls;

import iti.jets.database.entities.Country;
import jakarta.persistence.EntityManager;

public class CountryRepoImpl extends GenericRepo<Integer, Country> {

    public CountryRepoImpl(EntityManager entityManager) {
        super(entityManager, Country.class);
    }

}
