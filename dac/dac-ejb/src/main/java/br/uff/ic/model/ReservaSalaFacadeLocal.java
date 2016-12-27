/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.ReservaSala;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface ReservaSalaFacadeLocal {

    void create(ReservaSala reservaSala);

    void edit(ReservaSala reservaSala);

    void remove(ReservaSala reservaSala);

    ReservaSala find(Object id);

    List<ReservaSala> findAll();

    List<ReservaSala> findRange(int[] range);

    int count();
    
}
