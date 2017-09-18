package com.camera.of.city.mvc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class AbstractDAO<T> {

    private Class<?> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractDAO(Class<T> entityClass) {
        this.setEntityClass(entityClass);
    }

    public AbstractDAO() {
    }

    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public T save(T entity)  {

            getEntityManager().persist(entity);
            getEntityManager().flush();

        return entity;
    }

}
