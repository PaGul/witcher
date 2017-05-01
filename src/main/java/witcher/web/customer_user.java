/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
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
@SessionScoped
public class customer_user extends guest_instance {

    public customer_user() {
    }

    @EJB
    private GuestBean guestBean;
    @EJB
    private AdBean adBean;

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
}
