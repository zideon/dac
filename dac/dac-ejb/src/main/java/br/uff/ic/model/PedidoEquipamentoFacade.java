/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.PedidoEquipamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zideon
 */
@Stateless
public class PedidoEquipamentoFacade extends AbstractFacade<PedidoEquipamento> implements PedidoEquipamentoFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoEquipamentoFacade() {
        super(PedidoEquipamento.class);
    }
    
}
