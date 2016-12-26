/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.persistencia;

import br.uff.ic.modelo.ReservaSala;

/**
 *
 * @author zideon
 */
public class ReservaSalaDAO extends AbstractCRUD<ReservaSala,Long>{
     private static ReservaSalaDAO instance;

    public static ReservaSalaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaSalaDAO();
        }
        return instance;
    }

    private ReservaSalaDAO() {
        super(ReservaSala.class);
       entityManager = Conexao.getConexao();
    }
    
}
