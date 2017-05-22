/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.ejbs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import witcher.entities.ad;
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
        Collection<witcherorders> notNotificatedOrdersQueryList = getNewOrders(Customer);
        return (!notNotificatedOrdersQueryList.isEmpty() && notNotificatedOrdersQueryList.size() > 0);
    }

    private List<witcherorders> getNewOrders(guest Customer) {
        Query userAdsQuery = em.createQuery("SELECT a.id FROM ad a WHERE a.owner=:userid");
        List<Integer> userAdsIdList = userAdsQuery.setParameter("userid", Customer).getResultList();
        Query notNotificatedOrdersQuery = em.createQuery("SELECT wo FROM witcherorders wo WHERE wo.adId IN :adIds AND wo.notificated=0");
        List<witcherorders> notNotificatedOrdersQueryList = notNotificatedOrdersQuery.setParameter("adIds", userAdsIdList).getResultList();
        
//        List<witcherorders> notNotificatedOrdersQueryList = new LinkedList<>();
//        Collection<ad> adCollection = Customer.getAdCollection();
//        if (adCollection != null) {
//            for (ad Ad : adCollection) {
//                Collection<witcherorders> witcherordersCollection = Ad.getWitcherordersCollection();
//                if (witcherordersCollection != null) {
//                    for (witcherorders wo : witcherordersCollection) {
//                        if (wo.getNotificated() == 0) {
//                            notNotificatedOrdersQueryList.add(wo);
//                        }
//                    }
//                }
//            }
//        }
        return notNotificatedOrdersQueryList;
    }

    public List<witcherorders> getNewNotificatedOrders(guest Customer) {
        List<witcherorders> notificatedOrdersQueryList = getNewOrders(Customer);
//        for (witcherorders order : notificatedOrdersQueryList) {
//            order.setNotificated(1);
//        }
        return notificatedOrdersQueryList;
    }

    public witcherorders getOrder(Integer id) {
        return em.find(witcherorders.class, id);
    }

}
