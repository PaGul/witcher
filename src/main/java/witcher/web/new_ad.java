/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
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
    @EJB
    private GuestBean guestBean;
    
    public ad adInstance = new ad();

    public ad getAdInstance() {
        return adInstance;
    }

    public void setAdInstance(ad adInstance) {
        this.adInstance = adInstance;
    }
    
    public String newAd() {
        Integer userId = SessionUtils.getUserId();
        guest user = guestBean.getGuestById(userId);
        adInstance.setOwner(user);
        adBean.newAd(adInstance);
        return "index";
    }
    
}
