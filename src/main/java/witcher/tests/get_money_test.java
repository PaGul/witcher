/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.tests;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import witcher.ejbs.GuestBean;
import witcher.entities.guest;
import witcher.testentities.guestTest;
import witcher.util.SessionUtils;
import witcher.web.get_money;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class get_money_test implements Serializable {
    
    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;
    
    @EJB
    private GuestBean guestBean;
    
    public EntityManager getEm() {
        return em;
    }
    
    guest prevUser;
    HttpSession session;

    private void runBeforeTestMethod() {
        session = SessionUtils.getSession();
        if (session != null && SessionUtils.getUserObject()!=null) {
            prevUser = SessionUtils.getUser();
            session.invalidate();
        } 
    }

    public boolean addMoney_test(Object balance) {
        runBeforeTestMethod();
        boolean result = false;
        login();
        try {
            guestBean.changeBalance(SessionUtils.getUserObject(), (int) balance);
            guestTest changedGuest = em.find(guestTest.class, SessionUtils.getUserId());
            if (changedGuest == null) {
                result = false;
            } else {
                result = (changedGuest.getCreditcard().getBalance() == (int) balance);
            }
        } catch (Exception exp) {
            result = false;
        }
        runAfterTestMethod();
        return result;
    }

    private void runAfterTestMethod() {
        guestTest user = (guestTest) SessionUtils.getUserObject();
        user.getCreditcard().setBalance(0);
        if (prevUser != null) {
            session.setAttribute("user", prevUser);
            session.setAttribute("userid", prevUser.getId());
        } else {
            session.invalidate();
        }
    }

    private void login() {
//        guestTest currGuest = em.createNamedQuery("guestTest.findById", guestTest.class).setParameter("id", 1).getSingleResult();
        guestTest currGuest = em.find(guestTest.class, 1);
        session = SessionUtils.getNewSession();
        session.setAttribute("user", currGuest);
        session.setAttribute("userid", currGuest.getId());
    }
}
