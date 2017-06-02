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
import witcher.entities.witcher;
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class WitcherBean extends GuestBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void addWitcherOrder(witcherorders WitcherOrder) {
        em.persist(WitcherOrder);
    }
    
    public Boolean checkWitcherHasThisOrder(witcherorders WitcherOrder) {
        TypedQuery<witcherorders> Query = em.createNamedQuery("witcherorders.findByWitcherAndAd", witcherorders.class);
        Query.setParameter("wid", WitcherOrder.getWitcherId());
        Query.setParameter("aid", WitcherOrder.getAdId());
        List<witcherorders> Order = Query.getResultList();
        
        return !Order.isEmpty();
    }
    
    public Boolean checkWitcherProveTheOrder(witcherorders WitcherOrder) {
        TypedQuery<witcherorders> Query = em.createNamedQuery("witcherorders.findByWitcherAndAd", witcherorders.class);
        Query.setParameter("wid", WitcherOrder.getWitcherId());
        Query.setParameter("aid", WitcherOrder.getAdId());
        List<witcherorders> Order = Query.getResultList();
        return (!Order.isEmpty() && Order.get(0).getProof()!=null && Order.get(0).getProof().length>0);
    }
    
    public void deleteWitcherOrder(witcherorders WitcherOrder) {
        TypedQuery<witcherorders> Query = em.createNamedQuery("witcherorders.findByWitcherAndAd", witcherorders.class);
        Query.setParameter("wid", WitcherOrder.getWitcherId());
        Query.setParameter("aid", WitcherOrder.getAdId());
        List<witcherorders> Order = Query.getResultList();
        em.remove(Order.get(0));
    }
    
    public void proveOrder(witcherorders WitcherOrder, byte[] file) {
        TypedQuery<witcherorders> Query = em.createNamedQuery("witcherorders.findByWitcherAndAd", witcherorders.class);
        Query.setParameter("wid", WitcherOrder.getWitcherId());
        Query.setParameter("aid", WitcherOrder.getAdId());
        List<witcherorders> OrderList = Query.getResultList();
        witcherorders Order = OrderList.get(0);
        Order.setProof(file);
        Order.setNotificated(0);
        em.merge(Order);
    }
    
    public void addInfoAboutHorse(witcher params) {
        witcher witcherInfo = em.find(witcher.class, params.getGuestId());
        if (witcherInfo!=null) {
            witcherInfo.setHasHorse(params.getHasHorse());
        } else {
            em.persist(params);
        }
    }
}
