/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fabio
 * @param <T>
 * @param <ID>
 */
public interface CRUD<T extends Object, ID extends Serializable> {
    
    
    public T persist(final T object);

    public T merge(final T object);
    
    public void refresh(final T object);
    

    public T findOne(ID id);

    public boolean exists(ID id);

    public List<T> findAll();

    public long count();

    public void delete(ID id);

    public void delete(T t);
    
    public void deleteAll();

}
