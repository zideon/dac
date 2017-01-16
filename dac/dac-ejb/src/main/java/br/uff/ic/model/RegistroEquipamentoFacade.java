/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RegistroEquipamento;
import br.uff.ic.entities.RegistroSala;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author zideon
 */
@Stateless
public class RegistroEquipamentoFacade extends AbstractFacade<RegistroEquipamento> implements RegistroEquipamentoFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;
    
    private final Class type;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroEquipamentoFacade() {
        super(RegistroEquipamento.class);
        this.type = RegistroEquipamento.class;
    }

    @Override
    public List<RegistroEquipamento> findByTipo(String tipo) {
        String queryString = "select s from RegistroEquipamento s where s.tipo.tipo=:tipo";


        TypedQuery<RegistroEquipamento> setParameter = em.createQuery(queryString, type)
                .setParameter("tipo", tipo);
        return setParameter.getResultList();
    }
    
}
