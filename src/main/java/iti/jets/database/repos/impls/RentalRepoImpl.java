package iti.jets.database.repos.impls;

import iti.jets.database.entities.Rental;
import jakarta.persistence.EntityManager;

public class RentalRepoImpl extends GenericRepo<Integer, Rental> {

    public RentalRepoImpl(EntityManager entityManager) {
        super(entityManager, Rental.class);
    }

}
