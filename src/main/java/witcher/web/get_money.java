/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import entitiesInterfaces.guestInterface;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import witcher.ejbs.GuestBean;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class get_money extends guest_instance {

    public get_money() {
    }

    @EJB
    private GuestBean guestBean;

    int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String addMoney() {
        guestInterface user = SessionUtils.getUserObject();
        guestBean.changeBalance(user, money);
        return "index";
    }
}
