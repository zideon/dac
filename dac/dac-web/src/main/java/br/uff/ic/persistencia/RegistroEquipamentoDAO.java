/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.RegistroEquipamento;

/**
 *
 * @author zideon
 */
public class RegistroEquipamentoDAO extends AbstractCRUD<RegistroEquipamento,Long>{
     private static RegistroEquipamentoDAO instance;

    public static RegistroEquipamentoDAO getInstance() {
        if (instance == null) {
            instance = new RegistroEquipamentoDAO();
        }
        return instance;
    }

    private RegistroEquipamentoDAO() {
        super(RegistroEquipamento.class);
       entityManager = Conexao.getConexao();
    }
    
}
