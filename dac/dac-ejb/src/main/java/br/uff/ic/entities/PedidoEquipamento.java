/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.entities;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zideon
 */
@Entity
@SequenceGenerator(name = "SequenciaPedidoEquipamento", sequenceName = "seq_id_pedido_equipamento")
public class PedidoEquipamento {
    @Id
    @GeneratedValue(generator = "SequenciaPedidoEquipamento", strategy = GenerationType.AUTO)
    private Long ID;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    @Temporal(TemporalType.TIME)
    private Calendar horaInicial;
    
    @Temporal(TemporalType.TIME)
    private Calendar horaFinal;
    
    @OneToOne
    private Usuario usuario;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Calendar horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Calendar getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
            
     
}
