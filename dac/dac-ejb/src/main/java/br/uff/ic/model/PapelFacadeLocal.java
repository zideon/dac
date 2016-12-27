/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.Papel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface PapelFacadeLocal {

    void create(Papel papel);

    void edit(Papel papel);

    void remove(Papel papel);

    Papel find(Object id);

    List<Papel> findAll();

    List<Papel> findRange(int[] range);

    int count();
    
}
