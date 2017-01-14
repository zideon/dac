package br.uff.ic.controller;

import br.uff.ic.controller.util.BuscaSalaModel;
import br.uff.ic.entities.Sala;
import br.uff.ic.controller.util.JsfUtil;
import br.uff.ic.controller.util.JsfUtil.PersistAction;
import br.uff.ic.model.SalaFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
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

@Named("salaController")
@SessionScoped
public class SalaController implements Serializable {

    @EJB
    private SalaFacadeLocal ejbFacade;

    
    private List<Sala> items = null;
    
     private List<Sala> result = null;
    
    private Sala selected;
    
    private BuscaSalaModel buscaSalaModel;

    public BuscaSalaModel getBuscaSalaModel() {
        return buscaSalaModel;
    }

    public void setBuscaSalaModel(BuscaSalaModel buscaSalaModel) {
        this.buscaSalaModel = buscaSalaModel;
    }

    public List<Sala> getResult() {
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    public void setResult(List<Sala> result) {
        this.result = result;
    }
    
    

    public SalaController() {
    }

    public Sala getSelected() {
        return selected;
    }

    public void setSelected(Sala selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SalaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Sala prepareCreate() {
        selected = new Sala();
        initializeEmbeddableKey();
        return selected;
    }
    public BuscaSalaModel prepareBusca() {
        buscaSalaModel = new BuscaSalaModel();
        return buscaSalaModel;
    }
    public void busca() {   
        result = getFacade().findAll();
    }
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SalaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SalaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SalaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Sala> getItems() {
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

    public Sala getSala(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Sala> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Sala> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Sala.class)
    public static class SalaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SalaController controller = (SalaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "salaController");
            return controller.getSala(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Sala) {
                Sala o = (Sala) object;
                return getStringKey(o.getNumero());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Sala.class.getName()});
                return null;
            }
        }

    }

}
