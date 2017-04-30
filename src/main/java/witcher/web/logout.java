/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class logout implements Serializable{

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public logout() {
    }
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
}
