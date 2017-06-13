/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import entitiesInterfaces.adInterface;
import entitiesInterfaces.guestInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import witcher.ejbs.AdBean;
import witcher.ejbs.GuestBean;
import witcher.ejbs.MonsterBean;
import witcher.entities.ad;
import witcher.entities.bestiary;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class new_ad implements Serializable {

    @EJB
    private AdBean adBean;

    @EJB
    private MonsterBean monsterBean;

    public adInterface adInstance = new ad();

    public adInterface getAdInstance() {
        return adInstance;
    }

    public void setAdInstance(adInterface adInstance) {
        this.adInstance = adInstance;
    }

    public String newAd() {
        guestInterface user = SessionUtils.getUserObject();
        adInstance.setOwner(user);
        Date date = new Date();
        adInstance.setAdDate(date);
        if (adInstance.getHeader() != null && adInstance.getHeader().length() > 0 && adInstance.getHeader().length() <= 100) {
            if (adInstance.getText() == null || (adInstance.getText() != null && adInstance.getText().length() <= 1000)) {
                if (adInstance.getPrice() >= 0 && adInstance.getPrice() <= 1000) {
                    adBean.newAd(adInstance);
                }
            }
        }
        return "index";
    }

    public List<SelectItem> getAllMonsters() {

        List<SelectItem> items = new ArrayList<SelectItem>();
        List<bestiary> monsterList = monsterBean.getMonsters();
        for (bestiary monster : monsterList) {
            items.add(new SelectItem(monster.getId(), monster.getName()));
        }
        return items;
    }

}
