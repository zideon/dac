/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller;

import br.uff.ic.entities.Sala;
import br.uff.ic.entities.TipoSala;
import br.uff.ic.model.RecursoSalaFacadeLocal;
import br.uff.ic.model.ReservaSalaFacadeLocal;
import br.uff.ic.model.SalaFacadeLocal;
import br.uff.ic.model.TipoSalaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zideon
 */
@ManagedBean(name ="salaController")
@SessionScoped
public class SalaController implements Serializable {

    @EJB
    private ReservaSalaFacadeLocal reservaSalaFacade;

    @EJB
    private RecursoSalaFacadeLocal recursoSalaFacade;

    @EJB
    private TipoSalaFacadeLocal tipoSalaFacade;

    @EJB
    private SalaFacadeLocal salaFacade;
    
    private Sala sala;
    private Map<String,Object> tipos;
    private String tipo="";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Map<String, Object> getTipos() {
        tipos = new HashMap<>();
        List<TipoSala> findAll = tipoSalaFacade.findAll();
        System.out.println("tamanho"+findAll.size());
        for (TipoSala tipoSala : findAll) {
            tipos.put(tipoSala.getID().toString(), tipoSala.getTipo());
        }
        return tipos;
    }

    public void setTipos(Map<String, Object> tipos) {
        this.tipos = tipos;
    }
    
    
    
    public Sala getSala() {
        if(sala==null){
            sala = new Sala();
        }
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    /**
     * Creates a new instance of SalaController
     */
    public SalaController() {
        
    }
    public String salvar(){
        TipoSala find = tipoSalaFacade.find(Long.parseLong(tipo));
        sala.setTipo(find);
        salaFacade.create(sala);
        return "/index";
    }
}
