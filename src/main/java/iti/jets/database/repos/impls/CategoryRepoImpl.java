package iti.jets.database.repos.impls;

import iti.jets.database.entities.Category;
import jakarta.persistence.EntityManager;

public class CategoryRepoImpl extends GenericRepo<Integer, Category> {

    public CategoryRepoImpl(EntityManager entityManager) {
        super(entityManager, Category.class);
    }

}