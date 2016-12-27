/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RecursoSala;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface RecursoSalaFacadeLocal {

    void create(RecursoSala recursoSala);

    void edit(RecursoSala recursoSala);

    void remove(RecursoSala recursoSala);

    RecursoSala find(Object id);

    List<RecursoSala> findAll();

    List<RecursoSala> findRange(int[] range);

    int count();
    
}
