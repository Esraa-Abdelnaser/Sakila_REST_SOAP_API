package iti.jets.database.repos.impls;

import iti.jets.database.entities.Inventory;
import jakarta.persistence.EntityManager;

public class InventoryRepoImpl extends GenericRepo<Integer, Inventory> {

    public InventoryRepoImpl(EntityManager entityManager) {
        super(entityManager, Inventory.class);
    }

}
