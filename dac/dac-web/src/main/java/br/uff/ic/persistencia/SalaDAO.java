/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.Sala;

/**
 *
 * @author zideon
 */
public class SalaDAO extends AbstractCRUD<Sala,String>{
     private static SalaDAO instance;

    public static SalaDAO getInstance() {
        if (instance == null) {
            instance = new SalaDAO();
        }
        return instance;
    }

    private SalaDAO() {
        super(Sala.class);
       entityManager = Conexao.getConexao();
    }
}
