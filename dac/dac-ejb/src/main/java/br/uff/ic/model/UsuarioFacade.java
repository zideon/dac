/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import br.uff.ic.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zideon
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "dac")
    private EntityManager em;

    private final Class type;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
        type = Usuario.class;
    }

    @Override
    public Usuario autentificar(String login, String senha) {
        String queryString = "select u from " + type.getName() +" u where u.login=:login and u.senha=:senha";
        return (Usuario) em.createQuery(queryString,type).setParameter("login", login).setParameter("senha", senha).getSingleResult();
    }
    
}
