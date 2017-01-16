/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.RecursoSala;
import br.uff.ic.entities.Sala;
import br.uff.ic.entities.TipoSala;
import br.uff.ic.entities.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

/**
 *
 * @author zideon
 */
@Stateless
public class SalaFacade extends AbstractFacade<Sala> implements SalaFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalaFacade() {
        super(Sala.class);
        type = Sala.class;
    }

    @Override
    public List<Sala> findBusca(Date data, Date inicio, Date fim, int capacidade, TipoSala tipo, List<RecursoSala> recursos) {

        String queryString = "select s from Sala s where s.capacidade >=:capacidade"
                + " and s.tipo=:tipo"
                + " and s NOT IN (select r.sala from ReservaSala r where  r.data=:data and ((r.horaInicial<=:horaInicial and r.horaFinal>=:horaInicial) or (r.horaInicial<=:horaFinal and r.horaFinal>=:horaFinal)))";


        TypedQuery<Sala> setParameter = em.createQuery(queryString, type)
                .setParameter("data", data, TemporalType.DATE)
                .setParameter("horaInicial", inicio, TemporalType.TIME)
                .setParameter("horaFinal", fim, TemporalType.TIME)
                .setParameter("capacidade", capacidade)
                .setParameter("tipo", tipo);

        List<Sala> resultList = setParameter .getResultList();

        List<Sala> saida = new ArrayList<>();
        if (!recursos.isEmpty()) {
            for (Sala sala : resultList) {
                List<RecursoSala> recursosSala = sala.getRecursos();
                if(recursosSala.containsAll(recursos)){
                    saida.add(sala);
                }
            }
            return saida;
        } else {
        return resultList;
        }
    }

}
