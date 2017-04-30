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
        TypedQuery <ad> query = em.createNamedQuery("ad.findAll", ad.class);
        return query.getResultList();
    }
    
    private TypedQuery<ad> getAdsByIdQuery(String id) {
        Long idLong = 0l;
        try {
            idLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
        }
        TypedQuery <ad> query = em.createNamedQuery("ad.findById", ad.class);
        TypedQuery<ad> adByIdQuery = query.setParameter("id", idLong);
        return adByIdQuery;
    }
    
    public int checkIfQueryExists(String id) {
        List<ad> ads = getAdsByIdQuery(id).getResultList();
        return ads.size();
    }
    
    public ad getAdById(String id) {
        ad ad_instance = (ad)getAdsByIdQuery(id).getSingleResult();
        return ad_instance;
    }
    
    public void newAd(ad adInstance) {
        em.persist(adInstance);
    }
    
    public ad update(ad Ad) {
        return em.merge(Ad);
    }
    
}
