/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;
import witcher.ejbs.AdBean;
import witcher.ejbs.GuestBean;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class promotion {

    public promotion() {
    }
    @EJB
    private GuestBean guestBean;
    @EJB
    private AdBean adBean;
    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public String saveAdToSession(ad_instance Ad) {
        HttpSession session = SessionUtils.getSession();
        System.out.println(Ad.getAd()==null);
        session.setAttribute("ad", Ad.getAd());
        return "promotion";
    }
    
    
    
    public String promote() {
        HttpSession session = SessionUtils.getSession();
        ad currAd = (ad) session.getAttribute("ad");
        guest user = SessionUtils.getUser();
        int balance = user.getBalance();
        user.setBalance(balance-money);
        guestBean.update(user);
        int rating = currAd.getRating();
        currAd.setRating(rating+money);
        adBean.update(currAd);
        session.removeAttribute("ad");
        return "index";
    }
    
}
