/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.controller;

import br.uff.ic.entities.Usuario;
import br.uff.ic.model.UsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author zideon
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    
    
    /**
     * Creates a new instance of LoginController
     */
    private Usuario logado;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginController() {
    }

    public Usuario getLogado() {
        if (logado == null) {
            logado = new Usuario();
        }
        return logado;
    }

    public String envia() {
        System.out.println("login" + logado.getLogin());
        Usuario autentificar = usuarioFacade.autentificar(logado.getLogin(), logado.getSenha());
        if (autentificar != null) {
            logado = autentificar;
            return "/index";
        } else {
            logado = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        }
    }

    public String deslogar() {
        logado = new Usuario();
        return "/index";

    }

    public void setLogado(Usuario logado) {
        this.logado = logado;
    }

}
