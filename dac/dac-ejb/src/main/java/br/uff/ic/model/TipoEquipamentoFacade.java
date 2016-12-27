/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.TipoEquipamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zideon
 */
@Stateless
public class TipoEquipamentoFacade extends AbstractFacade<TipoEquipamento> implements TipoEquipamentoFacadeLocal {

    @PersistenceContext(unitName = "br.uff.ic_dac-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEquipamentoFacade() {
        super(TipoEquipamento.class);
    }
    
}
