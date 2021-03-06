/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import entitiesInterfaces.guestInterface;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import witcher.entities.creditcard;
import witcher.entities.guest;
import witcher.testentities.guestTest;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class GuestBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public List<guest> getGuests() {
        TypedQuery<guest> query = em.createNamedQuery("guest.findAll", guest.class);
        return query.getResultList();
    }

    public Boolean validate(String username, String password) {
        TypedQuery<guest> query = em.createNamedQuery("guest.findByLoginAndPassword", guest.class);
        return !(query.setParameter("login", username).setParameter("password", password).getResultList().isEmpty());
    }

    public void addGuest(guest guestInst) {
        creditcard crcard = new creditcard();
        em.persist(crcard);
        em.flush();
        guestInst.setCrCardId(crcard.getId());
        em.persist(guestInst);
    }

    public Boolean checkIfQueryExists(String query) {
        return getGuestById(query) != null;
    }

    public guest getGuestById(int id) {
        guest guest_instance = em.find(guest.class, id);
        return guest_instance;
    }

//    public guestTest getTestGuestById(int id) {
//        guestTest guest_instance = em.find(guestTest.class, id);
//        return guest_instance;
//    }
    public guest getGuestById(String idStr) {
        Integer id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {

        }
        return getGuestById(id);
    }

    public String getJobName(String id) {
        guest guest_instance = getGuestById(id);
        switch (guest_instance.getUserType()) {
            case 1:
                return "Witcher";
            case 2:
                return "Customer";
            case 3:
                return "Herbalist";
            case 4:
                return "Blacksmith";
            default:
                return "Guest";
        }
    }

    public Boolean hasUserWithLogin(String login) {
        return getUserByLogin(login) != null;
    }

    public boolean hasSecretQuestion(String login) {
        guest currUser = getUserByLogin(login);
        if (currUser == null) {
            return false;
        }
        return currUser.getSecretquestion() != null;
    }

    public Integer getIdByLogin(String login) {
        guest currUser = getUserByLogin(login);
        if (currUser == null) {
            return 0;
        }
        return currUser.getId();
    }

    private guest getUserByLogin(String login) {
        TypedQuery<guest> query = em.createNamedQuery("guest.findByLogin", guest.class);
        List resultList = query.setParameter("login", login).getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        guest currUser = (guest) (resultList.get(0));
        return currUser;
    }

    public String getSecretQuestion(Integer id) {
        guest currUser = em.find(guest.class, id);
        return currUser.getSecretquestion();
    }

    public String getSecretAnswer(Integer id) {
        guest currUser = em.find(guest.class, id);
        return currUser.getSecretanswer();
    }

    public void changePassword(Integer id, String newPassword) {
        guest currUser = em.find(guest.class, id);
        currUser.setPassword(newPassword);
    }

    
    public void changeBalance(guestInterface User, int delta) {
        if (delta <= 1000 && delta >= 0) {
            creditcard cr_card = (creditcard) User.getCreditcard();
            int balance = cr_card.getBalance();
            cr_card.setBalance(balance + delta);
            em.merge(cr_card);
        }
    }
    
    public void changeRating(guest User, int delta) {
        int rating = User.getRating();
        User.setRating(rating + delta);
        em.merge(User);
    }

}
