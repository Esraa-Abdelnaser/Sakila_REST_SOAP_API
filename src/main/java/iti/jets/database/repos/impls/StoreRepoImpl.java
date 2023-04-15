package iti.jets.database.repos.impls;

import iti.jets.database.entities.Store;
import jakarta.persistence.EntityManager;

public class StoreRepoImpl extends GenericRepo<Integer, Store> {

    public StoreRepoImpl(EntityManager entityManager) {
        super(entityManager, Store.class);
    }

}
