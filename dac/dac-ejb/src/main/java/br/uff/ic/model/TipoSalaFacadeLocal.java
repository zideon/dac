/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.TipoSala;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface TipoSalaFacadeLocal {

    void create(TipoSala tipoSala);

    void edit(TipoSala tipoSala);

    void remove(TipoSala tipoSala);

    TipoSala find(Object id);

    List<TipoSala> findAll();

    List<TipoSala> findRange(int[] range);

    int count();
    
}
