/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.PedidoEquipamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zideon
 */
@Local
public interface PedidoEquipamentoFacadeLocal {

    void create(PedidoEquipamento pedidoEquipamento);

    void edit(PedidoEquipamento pedidoEquipamento);

    void remove(PedidoEquipamento pedidoEquipamento);

    PedidoEquipamento find(Object id);

    List<PedidoEquipamento> findAll();

    List<PedidoEquipamento> findRange(int[] range);

    int count();
    
}
