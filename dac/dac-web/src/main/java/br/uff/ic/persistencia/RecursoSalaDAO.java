/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.RecursoSala;

/**
 *
 * @author zideon
 */
public class RecursoSalaDAO extends AbstractCRUD<RecursoSala,Long>{
     private static RecursoSalaDAO instance;

    public static RecursoSalaDAO getInstance() {
        if (instance == null) {
            instance = new RecursoSalaDAO();
        }
        return instance;
    }

    private RecursoSalaDAO() {
        super(RecursoSala.class);
       entityManager = Conexao.getConexao();
    }
    
}
