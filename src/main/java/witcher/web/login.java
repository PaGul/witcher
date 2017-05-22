/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import witcher.ejbs.*;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class login implements Serializable {

    @EJB
    private GuestBean guestBean;

    /**
     * Creates a new instance of index
     */
    public login() {
    }
    private String username;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String validateUsernamePassword() {
        boolean valid = guestBean.validate(username, pwd);
        if (valid) {
            Integer guestId = guestBean.getIdByLogin(username);
            guest currGuest = guestBean.getGuestById(guestId);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("user", currGuest);
            session.setAttribute("userid", currGuest.getId());
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Password",
                            "Please enter correct username and Password"));
            return "signin";
        }
    }
    
    public Boolean getLoggedSession() {
        return SessionUtils.getUser()==null;
//        if (SessionUtils.getUser()!=null) {
//            return false;
//        } else {
//            return true;
//        }
    }

}
