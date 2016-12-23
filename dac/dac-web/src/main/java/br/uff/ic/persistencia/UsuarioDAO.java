/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.Usuario;
import java.util.List;

/**
 *
 * @author fabio
 */
public class UsuarioDAO extends AbstractCRUD<Usuario,Long> implements UsuarioJPA{

    private static UsuarioDAO instance;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private UsuarioDAO() {
        super(Usuario.class);
       entityManager = Conexao.getConexao();
    }

    @Override
    public Usuario autentificar(String login, String senha) {
        String queryString = "select u from " + type.getName() +" u where u.login=:login and u.senha=:senha";
        return (Usuario) entityManager.createQuery(queryString,type).setParameter("login", login).setParameter("senha", senha).getSingleResult();
    }
}
