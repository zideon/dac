/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.Equipamento;

/**
 *
 * @author zideon
 */
public class EquipamentoDAO extends AbstractCRUD<Equipamento,String>{
     private static EquipamentoDAO instance;

    public static EquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new EquipamentoDAO();
        }
        return instance;
    }

    private EquipamentoDAO() {
        super(Equipamento.class);
       entityManager = Conexao.getConexao();
    }
}
