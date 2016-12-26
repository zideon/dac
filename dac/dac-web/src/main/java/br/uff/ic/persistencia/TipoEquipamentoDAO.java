/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.TipoEquipamento;

/**
 *
 * @author zideon
 */
public class TipoEquipamentoDAO extends AbstractCRUD<TipoEquipamento,Long>{
     private static TipoEquipamentoDAO instance;

    public static TipoEquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new TipoEquipamentoDAO();
        }
        return instance;
    }

    private TipoEquipamentoDAO() {
        super(TipoEquipamento.class);
       entityManager = Conexao.getConexao();
    }
}
