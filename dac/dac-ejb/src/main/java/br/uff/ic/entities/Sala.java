/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author zideon
 */
@Entity
public class Sala implements Serializable {
    @Id
    private String numero;
    
    private TipoSala tipo;
    
    private int capacidade;
    
    @ManyToMany
    private List<RecursoSala> recursos;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<RecursoSala> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoSala> recursos) {
        this.recursos = recursos;
    }
    
    
}
