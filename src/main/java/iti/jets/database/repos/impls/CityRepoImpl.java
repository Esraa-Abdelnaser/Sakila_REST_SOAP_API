package iti.jets.database.repos.impls;

import iti.jets.database.entities.City;
import jakarta.persistence.EntityManager;

public class CityRepoImpl extends GenericRepo<Integer, City> {

    public CityRepoImpl(EntityManager entityManager) {
        super(entityManager, City.class);
    }

}
