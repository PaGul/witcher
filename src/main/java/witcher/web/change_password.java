/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import witcher.ejbs.GuestBean;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class change_password implements Serializable {

    @EJB
    private GuestBean guestBean;
    HttpSession session = SessionUtils.getSession();

    public change_password() {
    }
    Integer id;
    String password;
    String oldPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String changePassword() {
        id = SessionUtils.getUserId();
        guestBean.changePassword(id, password);
        session.invalidate();
        return "index";
    }
}
