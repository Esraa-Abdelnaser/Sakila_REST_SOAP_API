package iti.jets.database.repos.impls;


import iti.jets.database.repos.interfaces.Repo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenericRepo<K, E> implements Repo<K, E> {
    private final EntityManager entityManager;
    private final Class<E> entityClass;

    public GenericRepo(EntityManager entityManager, Class<E> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    @Override
    public E getById(K id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void insert(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}