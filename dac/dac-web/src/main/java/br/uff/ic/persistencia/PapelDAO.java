/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.Papel;

/**
 *
 * @author zideon
 */
public class PapelDAO extends AbstractCRUD<Papel,Long>{
     private static PapelDAO instance;

    public static PapelDAO getInstance() {
        if (instance == null) {
            instance = new PapelDAO();
        }
        return instance;
    }

    private PapelDAO() {
        super(Papel.class);
       entityManager = Conexao.getConexao();
    }
}
