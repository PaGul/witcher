/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import witcher.ejbs.GuestBean;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class guest_instance implements Serializable{
    @EJB
    private GuestBean guestBean;
    
    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("gquery");
    }
    
    public void checkIfQueryExists() throws IOException {
        if (!guestBean.checkIfQueryExists(getQuery())) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }
    
    public guest getGuest() {
        return guestBean.getGuestById(getQuery());
    }
    
    public String getJob() {
        return guestBean.getJobName(getQuery());
    }
    
    public Integer getMyId() {
        return SessionUtils.getUser().getId();
    }
}


