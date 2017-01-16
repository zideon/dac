/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.Equipamento;
import br.uff.ic.entities.Sala;
import br.uff.ic.entities.TipoEquipamento;
import java.util.Date;
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
public class EquipamentoFacade extends AbstractFacade<Equipamento> implements EquipamentoFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

     private final Class type;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipamentoFacade() {
        super(Equipamento.class);
        this.type = Equipamento.class;
    }

    @Override
    public List<Equipamento> findPedido(TipoEquipamento tipo, Date data, Date inicio, Date fim) {
        String queryString = "select s from Equipamento s where s.tipo=:tipo"
                + " and s NOT IN (select r.equipamento from ReservaEquipamento r where  r.pedido.data=:data and ((r.pedido.horaInicial<=:horaInicial and r.pedido.horaFinal>=:horaInicial) or (r.pedido.horaInicial<=:horaFinal and r.pedido.horaFinal>=:horaFinal)))";


        TypedQuery<Equipamento> setParameter = em.createQuery(queryString, type)
                .setParameter("data", data, TemporalType.DATE)
                .setParameter("horaInicial", inicio, TemporalType.TIME)
                .setParameter("horaFinal", fim, TemporalType.TIME)
                .setParameter("tipo", tipo);
        return setParameter.getResultList();
    }
    
}
