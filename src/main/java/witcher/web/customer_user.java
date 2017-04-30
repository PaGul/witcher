/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import witcher.ejbs.GuestBean;
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
    
    public Boolean getCustomerLoggedSession() {
        Integer userType = SessionUtils.getUserType();
        if (userType!=null && userType==2) {
            return true;
        } else {
            return false;
        }
    }
}
