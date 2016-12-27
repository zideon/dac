/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RegistroEquipamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface RegistroEquipamentoFacadeLocal {

    void create(RegistroEquipamento registroEquipamento);

    void edit(RegistroEquipamento registroEquipamento);

    void remove(RegistroEquipamento registroEquipamento);

    RegistroEquipamento find(Object id);

    List<RegistroEquipamento> findAll();

    List<RegistroEquipamento> findRange(int[] range);

    int count();
    
}
