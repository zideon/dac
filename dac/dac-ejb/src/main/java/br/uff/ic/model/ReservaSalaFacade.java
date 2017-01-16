/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.ReservaSala;
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
public class ReservaSalaFacade extends AbstractFacade<ReservaSala> implements ReservaSalaFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaSalaFacade() {
        super(ReservaSala.class);
        this.type = ReservaSala.class;
    }

    @Override
    public List<ReservaSala> findValidasWithDataCPF(Date data, String CPF) {
        String queryString = "select s from ReservaSala s where s.data =:data"
                + " and s.usuario.cpf = :cpf"
                + " and (s.horaInicial<=:hora and s.horaFinal>= :hora )"
                + " and s NOT IN (select r.reserva from RegistroSala r where r.tipo.tipo = 'RETIRADA')"
                + " and s NOT IN (select r.reserva from RegistroSala r where r.tipo.tipo = 'DEVOLUCAO')"
                + " and s NOT IN (select r.reserva from RegistroSala r where r.tipo.tipo = 'DEFEITO')";


        TypedQuery<ReservaSala> setParameter = em.createQuery(queryString, type)
                 .setParameter("cpf", CPF)
                .setParameter("data", data, TemporalType.DATE)
                .setParameter("hora", data, TemporalType.TIME);
        return setParameter.getResultList();
    }

}
