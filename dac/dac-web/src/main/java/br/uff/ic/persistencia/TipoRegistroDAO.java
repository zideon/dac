/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.TipoRegistro;

/**
 *
 * @author zideon
 */
public class TipoRegistroDAO extends AbstractCRUD<TipoRegistro,Long>{
     private static TipoRegistroDAO instance;

    public static TipoRegistroDAO getInstance() {
        if (instance == null) {
            instance = new TipoRegistroDAO();
        }
        return instance;
    }

    private TipoRegistroDAO() {
        super(TipoRegistro.class);
       entityManager = Conexao.getConexao();
    }
}
