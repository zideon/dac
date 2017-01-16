/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.PedidoEquipamento;
import br.uff.ic.entities.RegistroSala;
import br.uff.ic.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author zideon
 */
@Stateless
public class RegistroSalaFacade extends AbstractFacade<RegistroSala> implements RegistroSalaFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;
    private final Class type;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroSalaFacade() {
        super(RegistroSala.class);
        this.type =RegistroSala.class;
    }

    @Override
    public List<RegistroSala> findByTipo(String tipo) {
        String queryString = "select s from RegistroSala s where s.tipo.tipo=:tipo";


        TypedQuery<RegistroSala> setParameter = em.createQuery(queryString, type)
                .setParameter("tipo", tipo);
        return setParameter.getResultList();
    }
    
}
