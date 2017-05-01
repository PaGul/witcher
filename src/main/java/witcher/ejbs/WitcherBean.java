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
import javax.persistence.TypedQuery;
import witcher.entities.guest;
import witcher.entities.witcherorders;
import witcher.entities.witcherordersPK;

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

    public void addWitcherOrder(witcherordersPK WitcherOrderPK) {
        em.persist(new witcherorders(WitcherOrderPK));
    }
    
    public Boolean checkWitcherHasThisOrder(witcherordersPK WitcherOrder) {
        witcherorders Order = em.find(witcherorders.class, WitcherOrder);
        return Order!=null;
    }
    
    public Boolean checkWitcherProveTheOrder(witcherordersPK WitcherOrder) {
        witcherorders Order = em.find(witcherorders.class, WitcherOrder);
        return (Order!=null && Order.getProof()!=null && Order.getProof().length>0);
    }
    
    public void deleteWitcherOrder(witcherordersPK WitcherOrderPK) {
        witcherorders WitcherOrder = em.find(witcherorders.class, WitcherOrderPK);
        em.remove(WitcherOrder);
    }
    
    public void proveOrder(witcherordersPK WitcherOrderPK, byte[] file) {
        witcherorders WitcherOrder = em.find(witcherorders.class, WitcherOrderPK);
        WitcherOrder.setProof(file);
        em.merge(WitcherOrder);
    }
}
