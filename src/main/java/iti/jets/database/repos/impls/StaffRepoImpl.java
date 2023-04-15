package iti.jets.database.repos.impls;

import iti.jets.database.entities.Staff;
import jakarta.persistence.EntityManager;

public class StaffRepoImpl extends GenericRepo<Integer, Staff> {

    public StaffRepoImpl(EntityManager entityManager) {
        super(entityManager, Staff.class);
    }

}
