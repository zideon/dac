/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.ReservaEquipamento;

/**
 *
 * @author zideon
 */
public class ReservaEquipamentoDAO extends AbstractCRUD<ReservaEquipamento,Long>{
     private static ReservaEquipamentoDAO instance;

    public static ReservaEquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new ReservaEquipamentoDAO();
        }
        return instance;
    }

    private ReservaEquipamentoDAO() {
        super(ReservaEquipamento.class);
       entityManager = Conexao.getConexao();
    }
}
