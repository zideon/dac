/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.PedidoEquipamento;

/**
 *
 * @author zideon
 */
public class PedidoEquipamentoDAO extends AbstractCRUD<PedidoEquipamento,Long>{
     private static PedidoEquipamentoDAO instance;

    public static PedidoEquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoEquipamentoDAO();
        }
        return instance;
    }

    private PedidoEquipamentoDAO() {
        super(PedidoEquipamento.class);
       entityManager = Conexao.getConexao();
    }
}
