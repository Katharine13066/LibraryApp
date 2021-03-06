package by.intexsoft.study.library.repository.impl;

import by.intexsoft.study.library.repository.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class DaoImpl<T> implements Dao<T> {

    private EntityManager entityManager;

    private final Class<T> clazz;

    public DaoImpl(EntityManager entityManager, Class clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public T createEntity(T t){
        entityManager.persist(t);
        return t;
    }

    @Override
    public T updateEntity(T t) {
        try {
            entityManager.merge(t);
            return t;
        }  catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(clazz);
        Root<T> root = criteriaDelete.from(clazz);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));
        Query query = entityManager.createQuery(criteriaDelete);
        query.executeUpdate();
    }

    @Override
    public void deleteAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(clazz);
        criteriaDelete.from(clazz);
        Query query = entityManager.createQuery(criteriaDelete);
        query.executeUpdate();
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}