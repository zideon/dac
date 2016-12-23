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
 * @author fabio
 */
@Entity
@SequenceGenerator(name = "SequenciaUsuario", sequenceName = "seq_id_usuario")
public class Usuario implements Serializable {

     public Long getID() {
        return ID;
    }
    
    @Id
    @GeneratedValue(generator = "SequenciaUsuario", strategy = GenerationType.AUTO)
    private Long ID;
    
    private String login;
    private String senha;
    
    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
