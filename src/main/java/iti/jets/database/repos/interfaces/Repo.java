package iti.jets.database.repos.interfaces;

import java.util.List;

public interface Repo <K, E>{

    List<E> getAll();

    E getById(K id);

    void insert(E entity);

    void update(E entity);

    void delete(E entity);
}
