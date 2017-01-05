/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller;

import br.uff.ic.entities.Equipamento;
import br.uff.ic.entities.TipoEquipamento;
import br.uff.ic.model.TipoEquipamentoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zideon
 */
@ManagedBean(name = "equipamentoController")
@SessionScoped
public class EquipamentoController implements Serializable {

    @EJB
    private TipoEquipamentoFacadeLocal tipoEquipamentoFacade;

    @EJB
    private br.uff.ic.model.EquipamentoFacadeLocal equipamentoFacade;

    
    
    /**
     * Creates a new instance of EquipamentoController
     */
    public EquipamentoController() {
    }
    public List<TipoEquipamento> findAll(){
        
        return tipoEquipamentoFacade.findAll();
    }
    public void printa(){
        System.out.println("tentou printar");
    }
}
