/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zideon
 */
@Entity
@SequenceGenerator(name = "SequenciaReservaEquipamento", sequenceName = "seq_id_reserva_equipamento")
public class ReservaEquipamento implements Serializable {
    @Id
    @GeneratedValue(generator = "SequenciaReservaEquipamento", strategy = GenerationType.AUTO)
    private Long ID;
    
    @OneToOne
    private PedidoEquipamento pedido;
    
    @OneToOne
    private Equipamento equipamento;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public PedidoEquipamento getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEquipamento pedido) {
        this.pedido = pedido;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    
    
}
