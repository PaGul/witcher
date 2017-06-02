/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import witcher.entities.customer;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class CustomerBean extends GuestBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void addRegion(customer params) {
        customer customerInfo = em.find(customer.class, params.getGuestId());
        if (customerInfo!=null) {
            customerInfo.setRegion(params.getRegion());
        } else {
            em.persist(params);
        }
    }
}
