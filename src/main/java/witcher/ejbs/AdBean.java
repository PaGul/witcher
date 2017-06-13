/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import entitiesInterfaces.adInterface;
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
            return null;
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
        TypedQuery<ad> adsByIdQuery = getAdsByIdQuery(id);
        if (adsByIdQuery==null) return null;
        ad ad_instance = adsByIdQuery.getSingleResult();
        return ad_instance;
    }

    public void newAd(adInterface adInstance) {
        em.persist(adInstance);
    }

    
    public void changeRating(ad Ad, int delta) {
        int rating = Ad.getRating();
        Ad.setRating(rating+delta);
        em.merge(Ad);
    }

}