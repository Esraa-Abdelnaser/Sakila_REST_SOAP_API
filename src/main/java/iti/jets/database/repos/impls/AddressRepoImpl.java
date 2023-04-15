package iti.jets.database.repos.impls;

import iti.jets.database.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressRepoImpl extends GenericRepo<Integer, Address> {

    public AddressRepoImpl(EntityManager entityManager) {
        super(entityManager, Address.class);
    }

}
