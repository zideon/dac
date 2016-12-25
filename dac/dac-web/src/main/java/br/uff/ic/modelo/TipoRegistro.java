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
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zideon
 */
@Entity
@SequenceGenerator(name = "SequenciaTipoRegistro", sequenceName = "seq_id_tipo_registro")
public class TipoRegistro implements Serializable {
    @Id
    @GeneratedValue(generator = "SequenciaTipoRegistro", strategy = GenerationType.AUTO)
    private Long ID;
    
    private String tipo;
}
