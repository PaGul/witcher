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
import witcher.ejbs.AdBean;
import witcher.entities.ad;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class ad_instance implements Serializable {
    @EJB
    private AdBean adBean;
    
    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adquery");
    }
    
    public void checkIfQueryExists() throws IOException {
        if (adBean.checkIfQueryExists(getQuery())==0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }
    
    public ad getAd() {
        return adBean.getAdById(getQuery());
    }
    
   
    
}
