/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RegistroSala;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface RegistroSalaFacadeLocal {

    void create(RegistroSala registroSala);

    void edit(RegistroSala registroSala);

    void remove(RegistroSala registroSala);

    RegistroSala find(Object id);

    List<RegistroSala> findAll();

    List<RegistroSala> findRange(int[] range);

    int count();
    
}
