/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fabio
 */
public class Conexao {

    private static EntityManager conexao;

    public static EntityManager getConexao() {
        if (conexao == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.uff.ic_dac-ejb_ejb_1.0PU");
            
            conexao = emf.createEntityManager();
        }
        return conexao;
    }

}
