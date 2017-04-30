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
@RequestScoped
public class recoverpassword implements Serializable {
    
    @EJB
    private GuestBean guestBean;

    public recoverpassword() {
    }
    Integer id;
    String login;
    String password;
    String secretQuestion;
    String secretAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
    
    public String getSecretQuestion() {
        return secretQuestion;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

   
    public String goToAnsweringQuestion() {
        id = guestBean.getIdByLogin(login);
        secretQuestion = guestBean.getSecretQuestion(id);
        return "asksecretquestion";
    }
    
    public String checkSecretAnswer() {
        HttpSession session = SessionUtils.getSession();
        if (secretAnswer.equals(guestBean.getSecretAnswer(id))) {
            session.setAttribute("userid", id);
            return "changepassword";
        } else {
            return "wrong_secret_answer";
        }
    }
}
