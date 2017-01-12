/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author zideon
 */
@Entity
public class Sala implements Serializable {
    @Id
    private String numero;
    
    @OneToOne
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + this.capacidade;
        hash = 97 * hash + Objects.hashCode(this.recursos);
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
        final Sala other = (Sala) obj;
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.recursos, other.recursos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sala{" + "numero=" + numero + ", tipo=" + tipo + ", capacidade=" + capacidade + ", recursos=" + recursos + '}';
    }
    
    
}
