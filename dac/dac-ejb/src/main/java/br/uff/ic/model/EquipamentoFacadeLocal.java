/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.Equipamento;
import br.uff.ic.entities.TipoEquipamento;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface EquipamentoFacadeLocal {

    void create(Equipamento equipamento);

    void edit(Equipamento equipamento);

    void remove(Equipamento equipamento);

    Equipamento find(Object id);

    List<Equipamento> findAll();

    List<Equipamento> findRange(int[] range);

    int count();
    
    List<Equipamento> findPedido(TipoEquipamento tipo, Date data, Date horarioInicial , Date horarioFinal );
    
}
