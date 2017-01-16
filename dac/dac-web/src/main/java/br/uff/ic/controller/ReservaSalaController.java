package br.uff.ic.controller;

import br.uff.ic.entities.ReservaSala;
import br.uff.ic.controller.util.JsfUtil;
import br.uff.ic.controller.util.JsfUtil.PersistAction;
import br.uff.ic.entities.RegistroEquipamento;
import br.uff.ic.entities.RegistroSala;
import br.uff.ic.entities.ReservaEquipamento;
import br.uff.ic.entities.Sala;
import br.uff.ic.model.RegistroSalaFacadeLocal;
import br.uff.ic.model.ReservaSalaFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("reservaSalaController")
@SessionScoped
public class ReservaSalaController implements Serializable {

    @EJB
    private RegistroSalaFacadeLocal registroSalaFacade;

    @EJB
    private ReservaSalaFacadeLocal ejbFacade;
    
    
    
    private List<ReservaSala> items = null;
    private List<ReservaSala> buscaPorCPF = null;
    private ReservaSala selected;

    private String CPF;
    
    private RegistroSala registro;
    

    public RegistroSala getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroSala registro) {
        this.registro = registro;
    }

    
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public ReservaSalaController() {
    }

    public ReservaSala getSelected() {
        return selected;
    }

    public void setSelected(ReservaSala selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReservaSalaFacadeLocal getFacade() {
        return ejbFacade;
    }
    public void buscar() {
        // verifica se cpf é valido
        JsfUtil.addSuccessMessage("buscado com sucesso");

    }

    public ReservaSala prepareCreate() {
        selected = new ReservaSala();
        selected.setSala(new Sala());
        initializeEmbeddableKey();
        return selected;
    }
    public RegistroSala prepareCreateRegistro() {
        registro = new RegistroSala();
        initializeEmbeddableKey();
        return registro;
    }
    public void salvarRegistro() {
        registro.setReserva(selected);
        Date data = new Date();
        registro.setData(data);
        registro.setHora(data);
        registroSalaFacade.create(registro);
        CPF= null;
        selected=null;
        registro=null;
        
        JsfUtil.addSuccessMessage("registro salvo com sucesso");
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReservaSalaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReservaSalaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReservaSalaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ReservaSala> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<ReservaSala> getBuscaPorCPF() {
        if(CPF !=null){
        buscaPorCPF = getFacade().findValidasWithDataCPF(new Date(), CPF);
        return buscaPorCPF;
        }else { 
            return new ArrayList<>();
        }
    }

    public void setBuscaPorCPF(List<ReservaSala> buscaPorCPF) {
        this.buscaPorCPF = buscaPorCPF;
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ReservaSala getReservaSala(Long id) {
        return getFacade().find(id);
    }

    public List<ReservaSala> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ReservaSala> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ReservaSala.class)
    public static class ReservaSalaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReservaSalaController controller = (ReservaSalaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reservaSalaController");
            return controller.getReservaSala(getKey(value));
        }

        Long getKey(String value) {
            Long key;
            key = Long.parseLong(value);
            return key;
        }

        String getStringKey(Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ReservaSala) {
                ReservaSala o = (ReservaSala) object;
                return getStringKey(o.getID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ReservaSala.class.getName()});
                return null;
            }
        }

    }

}
