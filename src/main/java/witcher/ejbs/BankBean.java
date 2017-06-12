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
import witcher.entities.bank;
import witcher.entities.creditcard;
import witcher.entities.guest;
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@Stateless
public class BankBean {

    @PersistenceContext(unitName = "VedmakJSFPU")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public Boolean pay(witcherorders Order) {
        guest Witcher = (guest) Order.getWitcherId();
        ad Ad = (ad) Order.getAdId();
        guest AdOwner = (guest) Ad.getOwner();
        creditcard AdOwnerCreditCard = (creditcard) AdOwner.getCreditcard();
        int oldBalance = AdOwnerCreditCard.getBalance();
        int adPrice = Ad.getPrice();
        // деньги за пользование сайтом и коммиссия банка
        int commision = (int)(adPrice*0.03 + adPrice*AdOwnerCreditCard.getBank().getCommision());
        if (oldBalance >= adPrice + commision) {
            AdOwnerCreditCard.setBalance(oldBalance - adPrice - commision);
            creditcard WitcherCreditCard = (creditcard) Witcher.getCreditcard();
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
    
    public List<bank> getBanks() {
        TypedQuery<bank> query = em.createNamedQuery("bank.findAll", bank.class);
        return query.getResultList();
    }
    
    public void changeBank(guest User, Integer bankId) {
        creditcard userCreditCard = (creditcard) User.getCreditcard();
        userCreditCard.setBankId(bankId);
        em.merge(userCreditCard);
    }
}
