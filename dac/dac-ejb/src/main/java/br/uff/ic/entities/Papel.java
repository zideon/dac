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
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zideon
 */
@Entity
@SequenceGenerator(name = "SequenciaPapel", sequenceName = "seq_id_papel")
public class Papel implements Serializable {
    @Id
    @GeneratedValue(generator = "SequenciaPapel", strategy = GenerationType.AUTO)
    private Long ID;
    
    private String tipo;
}
