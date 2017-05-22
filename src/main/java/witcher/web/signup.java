/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import witcher.ejbs.GuestBean;
import witcher.entities.guest;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class signup implements Serializable {

    @EJB
    private GuestBean guestBean;

    /**
     * Creates a new instance of signup
     */
    public signup() {
    }
    public guest guestInstance = new guest();

    public guest getGuestInstance() {
        return guestInstance;
    }

    public void setGuestInstance(guest guestInstance) {
        this.guestInstance = guestInstance;
    }

    public String completeSignUp() {
        guestBean.addGuest(guestInstance);
        return "index";
    }
}
