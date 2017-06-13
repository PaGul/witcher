/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.tests;

import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import witcher.entities.guest;
import witcher.testentities.adTest;
import witcher.testentities.guestTest;
import witcher.util.SessionUtils;
import witcher.web.new_ad;

/**
 *
 * @author pavelgulaev
 */
public class new_ad_test {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    adTest adInstance;
    guest prevUser;
    HttpSession session;

    private void runBeforeTestMethod() {
        session = SessionUtils.getSession();
        if (session != null) {
            prevUser = SessionUtils.getUser();
            session.invalidate();
        } else {
            session = SessionUtils.getNewSession();
        }
    }

    public boolean newAd_test(String header, String text, Integer price) {
        runBeforeTestMethod();
        new_ad testClass = new new_ad();
        login();
        adInstance = new adTest(header, text, price, 0, new Date(), 1);
        testClass.setAdInstance(adInstance);
        testClass.newAd();
        TypedQuery<adTest> query = em.createNamedQuery("SELECT a FROM adTest a WHERE a.header=:header AND a.text=:text AND a.price=:price", adTest.class);
        query.setParameter("header", header);
        query.setParameter("text", text);
        query.setParameter("price", price);
        List<adTest> resultList = query.getResultList();
        boolean result = (resultList!=null && !resultList.isEmpty());
        runAfterTestMethod();
        return result;
    }

    private void runAfterTestMethod() {
        em.remove(adInstance);
        if (prevUser != null) {
            session.setAttribute("user", prevUser);
            session.setAttribute("userid", prevUser.getId());
        } else {
            session.invalidate();
        }
    }

    private void login() {
        guestTest currGuest = new guestTest(1, "Test", "1234", "test@test.com", "Test", 2, 0, 1);
        session.setAttribute("user", currGuest);
        session.setAttribute("userid", currGuest.getId());
    }
}
