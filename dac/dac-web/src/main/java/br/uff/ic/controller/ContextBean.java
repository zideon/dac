/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author fabio
 */
@Named(value = "contextBean")
@Dependent
public class ContextBean {

    /**
     * Creates a new instance of ContextBean
     */
    public ContextBean() {
    }

    public String getContext() {
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getContextName();
        return contextPath;
    }
}
