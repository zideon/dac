package br.uff.ic.controller;

import br.uff.ic.entities.TipoRegistro;
import br.uff.ic.controller.util.JsfUtil;
import br.uff.ic.controller.util.JsfUtil.PersistAction;
import br.uff.ic.model.TipoRegistroFacadeLocal;

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

@Named("tipoRegistroController")
@SessionScoped
public class TipoRegistroController implements Serializable {

    @EJB
    private TipoRegistroFacadeLocal ejbFacade;

    
    private List<TipoRegistro> items = null;
    private TipoRegistro selected;

    public TipoRegistroController() {
    }

    public TipoRegistro getSelected() {
        return selected;
    }

    public void setSelected(TipoRegistro selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TipoRegistroFacadeLocal getFacade() {
        return ejbFacade;
    }

    public TipoRegistro prepareCreate() {
        selected = new TipoRegistro();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TipoRegistroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TipoRegistroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TipoRegistroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TipoRegistro> getItems() {
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

    public TipoRegistro getTipoRegistro(Long id) {
        return getFacade().find(id);
    }

    public List<TipoRegistro> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TipoRegistro> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TipoRegistro.class)
    public static class TipoRegistroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoRegistroController controller = (TipoRegistroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoRegistroController");
            return controller.getTipoRegistro(getKey(value));
        }

        Long getKey(String value) {
            Long key;
            key =Long.parseLong(value);
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
            if (object instanceof TipoRegistro) {
                TipoRegistro o = (TipoRegistro) object;
                return getStringKey(o.getID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TipoRegistro.class.getName()});
                return null;
            }
        }

    }

}
