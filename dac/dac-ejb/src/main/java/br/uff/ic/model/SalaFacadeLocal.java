/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RecursoSala;
import br.uff.ic.entities.Sala;
import br.uff.ic.entities.TipoSala;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface SalaFacadeLocal {

    void create(Sala sala);

    void edit(Sala sala);

    void remove(Sala sala);

    Sala find(Object id);

    List<Sala> findAll();

    List<Sala> findRange(int[] range);

    int count();
    
     List<Sala> findBusca(Date data,Date inicio,Date fim , int capcidade , TipoSala tipo, List<RecursoSala> recursos);
}
