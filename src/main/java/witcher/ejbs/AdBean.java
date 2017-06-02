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
import javax.persistence.TypedQuery;
import witcher.entities.ad;
import witcher.entities.creditcard;
import witcher.entities.guest;
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class AdBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public List<ad> getAds() {
        TypedQuery<ad> query = em.createNamedQuery("ad.findAll", ad.class);
        return query.getResultList();
    }

    private TypedQuery<ad> getAdsByIdQuery(String id) {
        Integer idInteger = 0;
        try {
            idInteger = Integer.parseInt(id);
        } catch (NumberFormatException e) {
        }
        TypedQuery<ad> query = em.createNamedQuery("ad.findById", ad.class);
        TypedQuery<ad> adByIdQuery = query.setParameter("id", idInteger);
        return adByIdQuery;
    }

    public int checkIfQueryExists(String id) {
        List<ad> ads = getAdsByIdQuery(id).getResultList();
        return ads.size();
    }

    public ad getAdById(String id) {
        ad ad_instance = (ad) getAdsByIdQuery(id).getSingleResult();
        return ad_instance;
    }

    public void newAd(ad adInstance) {
        em.persist(adInstance);
    }

    
    public void changeRating(ad Ad, int delta) {
        int rating = Ad.getRating();
        Ad.setRating(rating+delta);
        em.merge(Ad);
    }

    public Boolean pay(witcherorders Order) {
        guest Witcher = Order.getWitcherId();
        ad Ad = Order.getAdId();
        guest AdOwner = Ad.getOwner();
        creditcard AdOwnerCreditCard = AdOwner.getCreditcard();
        int oldBalance = AdOwnerCreditCard.getBalance();
        int adPrice = Ad.getPrice();
        if (oldBalance >= adPrice) {
            AdOwnerCreditCard.setBalance(oldBalance - adPrice);
            creditcard WitcherCreditCard = Witcher.getCreditcard();
            int witcherBalance = WitcherCreditCard.getBalance();
            WitcherCreditCard.setBalance(witcherBalance + adPrice);
            AdOwner.setRating(AdOwner.getRating() + adPrice);
            Witcher.setRating(Witcher.getRating() + adPrice);
            em.merge(Witcher);
            em.merge(AdOwner);
            em.merge(AdOwnerCreditCard);
            em.merge(WitcherCreditCard);
            witcherorders orderToDelete = em.merge(Order);
            em.remove(orderToDelete);
            ad adToDelete = em.merge(Ad);
            em.remove(adToDelete);
            return true;
        } else {
            return false;
        }
    }

    public void rejectComplitedOrder(witcherorders Order) {
        witcherorders orderToDelete = em.merge(Order);
        em.remove(orderToDelete);
    }
}
