/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import witcher.ejbs.AdBean;
import witcher.ejbs.GuestBean;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class new_ad implements Serializable {
    @EJB
    private AdBean adBean;
    
    public ad adInstance = new ad();

    public ad getAdInstance() {
        return adInstance;
    }

    public void setAdInstance(ad adInstance) {
        this.adInstance = adInstance;
    }
    
    public String newAd() {
        guest user = SessionUtils.getUser();
        adInstance.setOwner(user);
        Date date = new Date();
        adInstance.setAdDate(date);
        adBean.newAd(adInstance);
        return "index";
    }
    
}
