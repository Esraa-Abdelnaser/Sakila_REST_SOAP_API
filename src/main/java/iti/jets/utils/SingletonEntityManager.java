package iti.jets.utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SingletonEntityManager {
    private static SingletonEntityManager instance = null;
    private final EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private SingletonEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ENM");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static SingletonEntityManager getInstance() {
        if (instance == null) {
            instance = new SingletonEntityManager();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}