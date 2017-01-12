/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.entities;

import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.ID);
        hash = 67 * hash + Objects.hashCode(this.pedido);
        hash = 67 * hash + Objects.hashCode(this.equipamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservaEquipamento other = (ReservaEquipamento) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReservaEquipamento{" + "ID=" + ID + ", pedido=" + pedido + ", equipamento=" + equipamento + '}';
    }
    
    
}
