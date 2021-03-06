/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.Equipamento;
import br.uff.ic.entities.PedidoEquipamento;
import br.uff.ic.entities.Usuario;
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
public class PedidoEquipamentoFacade extends AbstractFacade<PedidoEquipamento> implements PedidoEquipamentoFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoEquipamentoFacade() {
        super(PedidoEquipamento.class);
        type = PedidoEquipamento.class;
    }

    @Override
    public List<PedidoEquipamento> findByUsuario(Usuario usuario) {
       String queryString = "select u from " + type.getName() +" u where u.usuario=:usuario";
        return  em.createQuery(queryString,type).setParameter("usuario", usuario).getResultList();
    }

    @Override
    public List<PedidoEquipamento> findValidosWithDataAtual(Date data) {
        String queryString = "select s from PedidoEquipamento s where ( s.data >:data"
                + " or ( s.data =:data and s.horaInicial>=:hora) )"
                + " and s NOT IN (select r.pedido from ReservaEquipamento r)";


        TypedQuery<PedidoEquipamento> setParameter = em.createQuery(queryString, type)
                .setParameter("data", data, TemporalType.DATE)
                .setParameter("hora", data, TemporalType.TIME);
        return setParameter.getResultList();

    }
    
}
