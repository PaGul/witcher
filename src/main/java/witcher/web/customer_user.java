/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import witcher.ejbs.AdBean;
import witcher.ejbs.GuestBean;
import witcher.ejbs.NotificationBean;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.entities.witcherorders;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class customer_user extends guest_instance {

    public customer_user() {
    }

    @EJB 
    private NotificationBean notificationBean;

    public void checkAccessToCustomerPage() throws IOException {
        if (!getCustomerLoggedSession()) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }
    
    public Boolean getCustomerLoggedSession() {
        if (SessionUtils.getUser() != null && SessionUtils.getUser().getUserType() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkThisAd(ad_instance adInst) {
        if (!getCustomerLoggedSession()) {
            return false;
        }
        if (adInst.getAd().getOwner().getId() == SessionUtils.getUserId()) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("ad", adInst.getAd());
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean checkNotifications() {
        if (!getCustomerLoggedSession()) return false;
        guest customer = SessionUtils.getUser();
        return notificationBean.hasNewOrders(customer);
    }
}
