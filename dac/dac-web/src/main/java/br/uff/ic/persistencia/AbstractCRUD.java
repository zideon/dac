/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fabio
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractCRUD<T extends Object, ID extends Serializable> implements CRUD<T, ID> {

    protected Class type;

    protected EntityManager entityManager;

    public AbstractCRUD(final Class<T> type) {
        this.type = type;
    }

    public AbstractCRUD() {
    }
     @Override
    public void deleteAll(){
        List<T> findAll = findAll();
         for (T t : findAll) {
             delete(t);
         }
    }
    @Override
    public T persist(final T object) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public T merge(final T object) {
        try {
            entityManager.getTransaction().begin();
            T object2 = entityManager.merge(object);
            entityManager.getTransaction().commit();
            return object2;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public void refresh(final T object) {
        entityManager.refresh(object);
    }

    @Override
    public T findOne(ID id) {
        return (T) entityManager.find(type, id);
    }

    @Override
    public boolean exists(ID id) {
        return findOne(id) != null;
    }

    @Override
    public List<T> findAll() {
        String queryString = "select u from " + type.getName() +" u";
        return entityManager.createQuery(queryString,type).getResultList();
    }

    @Override
    public long count() {
        List<T> findAll = findAll();
        int count =0;
        if(findAll!=null){
            for (T t : findAll) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void delete(ID id) {
        T obj = findOne(id);
        delete(obj);
    }

    @Override
    public void delete(T t) {
         try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
