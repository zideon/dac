/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.TipoSala;
import br.uff.ic.modelo.Usuario;

/**
 *
 * @author zideon
 */
public class TipoSalaDAO extends AbstractCRUD<TipoSala,Long>{
     private static TipoSalaDAO instance;

    public static TipoSalaDAO getInstance() {
        if (instance == null) {
            instance = new TipoSalaDAO();
        }
        return instance;
    }

    private TipoSalaDAO() {
        super(TipoSala.class);
       entityManager = Conexao.getConexao();
    }
}