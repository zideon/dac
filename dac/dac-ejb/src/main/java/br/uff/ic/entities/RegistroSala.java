/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.entities;

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
@SequenceGenerator(name = "SequenciaRegistroSala", sequenceName = "seq_id_registro_sala")
public class RegistroSala implements Serializable {
    @Id
    @GeneratedValue(generator = "SequenciaRegistroSala", strategy = GenerationType.AUTO)
    private Long ID;
    
    @OneToOne
    private TipoRegistro tipo;
    
    @OneToOne
    private ReservaSala reserva;
}
