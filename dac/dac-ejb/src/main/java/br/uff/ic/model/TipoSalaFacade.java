/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.TipoSala;
import br.uff.ic.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zideon
 */
@Stateless
public class TipoSalaFacade extends AbstractFacade<TipoSala> implements TipoSalaFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSalaFacade() {
        super(TipoSala.class);
        type = TipoSala.class;
    }

    @Override
    public TipoSala findForTipo(String tipo) {
        String queryString = "select u from " + type.getName() +" u where u.tipo=:tipo";
        return (TipoSala) em.createQuery(queryString,type).setParameter("tipo", tipo).getSingleResult();
    }
    
}
