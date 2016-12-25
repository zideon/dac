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
@SequenceGenerator(name = "SequenciaRegistroEquipamento", sequenceName = "seq_id_registro_equipamento")
public class RegistroEquipamento implements Serializable {
    @Id
    @GeneratedValue(generator = "SequenciaRegistroSala", strategy = GenerationType.AUTO)
    private Long ID;
    
    @OneToOne
    private TipoRegistro tipo;
    
    @OneToOne
    private ReservaEquipamento reserva;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public TipoRegistro getTipo() {
        return tipo;
    }

    public void setTipo(TipoRegistro tipo) {
        this.tipo = tipo;
    }

    public ReservaEquipamento getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEquipamento reserva) {
        this.reserva = reserva;
    }
    
    
}
