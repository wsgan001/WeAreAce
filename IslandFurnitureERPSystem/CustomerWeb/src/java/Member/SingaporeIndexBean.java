/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import Entity.Store.OCRM.SetEntity;
import SessionBean.OCRM.CustomerWebModuleLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author apple
 */
@Named(value = "singaporeIndexBean")
@ViewScoped
public class SingaporeIndexBean {

    @EJB
    private CustomerWebModuleLocal cwml;

    private List<SetEntity> setList;
    private SetEntity set;

    public SingaporeIndexBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("web", "Singapore");
        setList = cwml.getSetList("Singapore");
    }

    public String viewMore(Long setId) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("setId", setId);

        return "set?faces-redirect=true";
    }

    public String view(Long setId) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("setId", setId);
        return "set?faces-redirect=true";

    }

    public CustomerWebModuleLocal getCwml() {
        return cwml;
    }

    public void setCwml(CustomerWebModuleLocal cwml) {
        this.cwml = cwml;
    }

    public List<SetEntity> getSetList() {
        return setList;
    }

    public void setSetList(List<SetEntity> setList) {
        this.setList = setList;
    }

    public SetEntity getSet() {
        return set;
    }

    public void setSet(SetEntity set) {
        this.set = set;
    }

}
