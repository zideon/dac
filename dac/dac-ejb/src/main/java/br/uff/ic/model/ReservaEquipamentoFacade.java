/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.PedidoEquipamento;
import br.uff.ic.entities.ReservaEquipamento;
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
public class ReservaEquipamentoFacade extends AbstractFacade<ReservaEquipamento> implements ReservaEquipamentoFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaEquipamentoFacade() {
        super(ReservaEquipamento.class);
        this.type =ReservaEquipamento.class;
    }

    @Override
    public List<ReservaEquipamento> findValidasWithDataCPF(Date data,String CPF) {
        String queryString = "select s from ReservaEquipamento s where s.pedido.data =:data"
                + " and s.pedido.usuario.cpf = :cpf"
                + " and (s.pedido.horaInicial<=:hora and s.pedido.horaFinal>= :hora )"
                + " and s NOT IN (select r.reserva from RegistroEquipamento r where r.tipo.tipo = 'RETIRADA')"
                + " and s NOT IN (select r.reserva from RegistroEquipamento r where r.tipo.tipo = 'DEVOLUCAO')"
                + " and s NOT IN (select r.reserva from RegistroEquipamento r where r.tipo.tipo = 'DEFEITO')";


        TypedQuery<ReservaEquipamento> setParameter = em.createQuery(queryString, type)
                 .setParameter("cpf", CPF)
                .setParameter("data", data, TemporalType.DATE)
                .setParameter("hora", data, TemporalType.TIME);
        return setParameter.getResultList();
    }
    
}
