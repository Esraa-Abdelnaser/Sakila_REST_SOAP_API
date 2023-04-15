package iti.jets.database.repos.impls;

import iti.jets.database.entities.Customer;
import jakarta.persistence.EntityManager;

public class CustomerRepoImpl extends GenericRepo<Integer, Customer> {

    public CustomerRepoImpl(EntityManager entityManager) {
        super(entityManager, Customer.class);
    }

}

