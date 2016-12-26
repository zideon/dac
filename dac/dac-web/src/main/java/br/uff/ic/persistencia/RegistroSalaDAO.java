/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.RegistroSala;

/**
 *
 * @author zideon
 */
public class RegistroSalaDAO extends AbstractCRUD<RegistroSala,Long>{
     private static RegistroSalaDAO instance;

    public static RegistroSalaDAO getInstance() {
        if (instance == null) {
            instance = new RegistroSalaDAO();
        }
        return instance;
    }

    private RegistroSalaDAO() {
        super(RegistroSala.class);
       entityManager = Conexao.getConexao();
    }
}
