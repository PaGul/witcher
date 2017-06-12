/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.tests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import witcher.entities.guest;
import witcher.testentities.guestTest;
import witcher.util.SessionUtils;
import witcher.web.get_money;

/**
 *
 * @author pavelgulaev
 */
public class get_money_test {
    
    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;
    
    public void runBeforeTestMethod() {
        HttpSession session = SessionUtils.getSession();
        if (session!=null) {
            session.invalidate();
        }
    }
    
    public void runAfterTestMethod() {
        guest user = SessionUtils.getUser();
        user.getCreditcard().setBalance(0);
    }

    public boolean addMoney_test() {
        runBeforeTestMethod();
        get_money testClass = new get_money();
        login();
        testClass.setMoney(10);
        testClass.addMoney();
        guestTest changedGuest = em.find(guestTest.class, SessionUtils.getUserId());
        boolean result = (changedGuest.getCreditcard().getBalance() == 10);
        runAfterTestMethod();
        return result;
    }
    
    private void login() {
        guestTest currGuest = new guestTest(1, "Test", "1234", "test@test.com", "Test", 1, 0, 1);
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("user", currGuest);
        session.setAttribute("userid", currGuest.getId());
    }
}
