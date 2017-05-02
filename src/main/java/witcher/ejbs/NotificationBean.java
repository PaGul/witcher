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
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class NotificationBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public Boolean hasNewOrders(guest Customer) {
        List<witcherorders> notNotificatedOrdersQueryList = getNewOrders(Customer);
        return (!notNotificatedOrdersQueryList.isEmpty() && notNotificatedOrdersQueryList.size()>0);
    }

    private List<witcherorders> getNewOrders(guest Customer) {
        Query userAdsQuery = em.createQuery("SELECT a.id FROM ad a WHERE a.owner=:userid");
        List<Integer> userAdsIdList = userAdsQuery.setParameter("userid", Customer).getResultList();
        Query notNotificatedOrdersQuery = em.createQuery("SELECT wo FROM witcherorders wo WHERE wo.adId IN :adIds AND wo.notificated=0");
        List<witcherorders> notNotificatedOrdersQueryList = notNotificatedOrdersQuery.setParameter("adIds", userAdsIdList).getResultList();
        return notNotificatedOrdersQueryList;
    }
    
    public List<witcherorders> getNewNotificatedOrders(guest Customer) {
        List<witcherorders> notificatedOrdersQueryList = getNewOrders(Customer);
//        for (witcherorders order : notificatedOrdersQueryList) {
//            order.setNotificated(1);
//        }
        return notificatedOrdersQueryList;
    }
    
    public witcherorders getOrder(Long id) {
        return em.find(witcherorders.class, id);
    }

}
