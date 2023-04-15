package iti.jets.database.repos.impls;

import iti.jets.database.entities.Country;
import jakarta.persistence.EntityManager;

public class countryRepoImpl extends GenericRepo<Integer, Country> {

    public countryRepoImpl(EntityManager entityManager) {
        super(entityManager, Country.class);
    }

}
