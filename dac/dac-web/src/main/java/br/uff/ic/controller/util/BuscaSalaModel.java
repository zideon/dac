/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller.util;

import br.uff.ic.entities.RecursoSala;
import br.uff.ic.entities.TipoSala;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zideon
 */
public class BuscaSalaModel {
    private Date data;
    
    private Date horaInicial;
    
    private Date horaFinal;
    
    private int capacidade;
    
    private TipoSala tipoSala;
    
    private List<RecursoSala> recursos;

    public BuscaSalaModel() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public List<RecursoSala> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoSala> recursos) {
        this.recursos = recursos;
    }
    
    
}
