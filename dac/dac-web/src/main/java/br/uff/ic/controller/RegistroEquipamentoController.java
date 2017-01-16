package br.uff.ic.controller;

import br.uff.ic.entities.RegistroEquipamento;
import br.uff.ic.controller.util.JsfUtil;
import br.uff.ic.controller.util.JsfUtil.PersistAction;
import br.uff.ic.model.RegistroEquipamentoFacadeLocal;
import br.uff.ic.model.TipoRegistroFacadeLocal;

import java.io.Serializable;
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

@Named("registroEquipamentoController")
@SessionScoped
public class RegistroEquipamentoController implements Serializable {

    @EJB
    private RegistroEquipamentoFacadeLocal ejbFacade;
    
    @EJB
    private TipoRegistroFacadeLocal tipoRegistroFacade;

    
    private List<RegistroEquipamento> items = null;
    private RegistroEquipamento selected;

    public RegistroEquipamentoController() {
    }

    public RegistroEquipamento getSelected() {
        return selected;
    }

    public void setSelected(RegistroEquipamento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RegistroEquipamentoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public RegistroEquipamento prepareCreate() {
        selected = new RegistroEquipamento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RegistroEquipamentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void createDevolucao() {
        if(selected!=null){
            RegistroEquipamento novo = new RegistroEquipamento();
            Date data = new Date();
            novo.setData(data);
            novo.setHora(data);
            novo.setReserva(selected.getReserva());
            novo.setTipo(tipoRegistroFacade.find(3L));
            ejbFacade.create(novo);
            JsfUtil.addSuccessMessage("registro de devolução criado com sucesso");
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RegistroEquipamentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RegistroEquipamentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RegistroEquipamento> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<RegistroEquipamento> getItemsComDefeito() {
            return getFacade().findByTipo("DEFEITO");
    }
    public List<RegistroEquipamento> getItemsRetirados() {
            return  getFacade().findByTipo("RETIRADA");
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

    public RegistroEquipamento getRegistroEquipamento(Long id) {
        return getFacade().find(id);
    }

    public List<RegistroEquipamento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RegistroEquipamento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RegistroEquipamento.class)
    public static class RegistroEquipamentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RegistroEquipamentoController controller = (RegistroEquipamentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "registroEquipamentoController");
            return controller.getRegistroEquipamento(getKey(value));
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
            if (object instanceof RegistroEquipamento) {
                RegistroEquipamento o = (RegistroEquipamento) object;
                return getStringKey(o.getID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RegistroEquipamento.class.getName()});
                return null;
            }
        }

    }

}
