/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.ReservaEquipamento;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface ReservaEquipamentoFacadeLocal {

    void create(ReservaEquipamento reservaEquipamento);

    void edit(ReservaEquipamento reservaEquipamento);

    void remove(ReservaEquipamento reservaEquipamento);

    ReservaEquipamento find(Object id);

    List<ReservaEquipamento> findAll();

    List<ReservaEquipamento> findRange(int[] range);

    int count();
    
     List<ReservaEquipamento> findValidasWithDataCPF(Date data,String CPF);
}
