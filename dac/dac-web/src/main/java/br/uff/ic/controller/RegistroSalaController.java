package br.uff.ic.controller;

import br.uff.ic.entities.RegistroSala;
import br.uff.ic.controller.util.JsfUtil;
import br.uff.ic.controller.util.JsfUtil.PersistAction;
import br.uff.ic.model.RegistroSalaFacadeLocal;

import java.io.Serializable;
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

@Named("registroSalaController")
@SessionScoped
public class RegistroSalaController implements Serializable {

    @EJB
    private RegistroSalaFacadeLocal ejbFacade;

    
    private List<RegistroSala> items = null;
    private RegistroSala selected;

    public RegistroSalaController() {
    }

    public RegistroSala getSelected() {
        return selected;
    }

    public void setSelected(RegistroSala selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RegistroSalaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public RegistroSala prepareCreate() {
        selected = new RegistroSala();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RegistroSalaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RegistroSalaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RegistroSalaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RegistroSala> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
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

    public RegistroSala getRegistroSala(Long id) {
        return getFacade().find(id);
    }

    public List<RegistroSala> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RegistroSala> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RegistroSala.class)
    public static class RegistroSalaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RegistroSalaController controller = (RegistroSalaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "registroSalaController");
            return controller.getRegistroSala(getKey(value));
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
            if (object instanceof RegistroSala) {
                RegistroSala o = (RegistroSala) object;
                return getStringKey(o.getID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RegistroSala.class.getName()});
                return null;
            }
        }

    }

}
