/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import witcher.entities.guest;

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
        return em.createQuery("SELECT g FROM guest g").getResultList();
    }

    public Boolean validate(String username, String password) {
        return !(em.createQuery("Select g from guest g where g.login = ?1 and g.password = ?2").setParameter(1, username).setParameter(2, password).getResultList().isEmpty());
    }

    public Boolean addGuest(guest guestInst) {
        em.persist(guestInst);
        return true;
    }

    public Boolean checkIfQueryExists(String query) {
        return getGuestById(query) != null;
    }

    public guest getGuestById(String idStr) {
        Integer id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {

        }

        guest guest_instance = (guest) (em.find(guest.class, id));
        return guest_instance;
    }

    public String getJobName(String id) {
        guest guest_instance = getGuestById(id);
        switch (guest_instance.getUserType()) {
            case 1:
                return "Witcher";
            case 2:
                return "Customer";
            default:
                return "Guest";
        }
    }

    
    public Boolean hasUserWithLogin(String login) {
        return !(em.createQuery("SELECT g FROM guest g WHERE g.login = :login").setParameter("login", login).getResultList().isEmpty());
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
        List resultList = em.createQuery("SELECT g FROM guest g WHERE g.login = :login").setParameter("login", login).getResultList();
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

    public Integer changePassword(Integer id, String newPassword) {
        guest currUser = em.find(guest.class, id);
        Query query = em.createQuery(
                "UPDATE guest SET password = :password "
                + "WHERE id=:id");
        int updateCount = query.setParameter("password", newPassword).setParameter("id", id).executeUpdate();
        return updateCount;
    }
}
