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
        return em.createQuery("SELECT a FROM ad a").getResultList();
    }
    
    public int checkIfQueryExists(String query) {
        Long id = 0l;
        try {
            id = Long.parseLong(query);
        } catch (NumberFormatException e) {
            
        }
        List<ad> ads = em.createQuery("SELECT a FROM ad a WHERE a.id = :id").setParameter("id", id).getResultList();
        return ads.size();
    }
    
    public ad getAdById(String query) {
        Long id = 0l;
        try {
            id = Long.parseLong(query);
        } catch (NumberFormatException e) {
            
        }
        ad ad_instance = (ad)(em.createQuery("SELECT a FROM ad a WHERE a.id = :id").setParameter("id", id).getSingleResult());
        return ad_instance;
    }
    
    public void newAd(ad adInstance) {
        em.persist(adInstance);
    }
    
}
