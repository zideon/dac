/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.TipoEquipamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface TipoEquipamentoFacadeLocal {

    void create(TipoEquipamento tipoEquipamento);

    void edit(TipoEquipamento tipoEquipamento);

    void remove(TipoEquipamento tipoEquipamento);

    TipoEquipamento find(Object id);

    List<TipoEquipamento> findAll();

    List<TipoEquipamento> findRange(int[] range);

    int count();
    
}
