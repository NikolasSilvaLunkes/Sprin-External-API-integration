package com.nikolas.webservicenikolas.generic.classes;

import com.nikolas.webservicenikolas.generic.interfaces.IDefaultRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class CIDefaultRepository<T extends DefaultModel> implements IDefaultRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

}
