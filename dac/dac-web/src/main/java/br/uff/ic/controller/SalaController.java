/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author zideon
 */
@Named(value = "salaController")
@SessionScoped
public class SalaController implements Serializable {

    /**
     * Creates a new instance of SalaController
     */
    public SalaController() {
    }
    
}
