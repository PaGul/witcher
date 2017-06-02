/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import witcher.ejbs.MonsterBean;
import witcher.ejbs.NotificationBean;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@ApplicationScoped
public class image implements Serializable{

    /**
     * Creates a new instance of image
     */
    public image() {
    }
    
    @EJB
    private NotificationBean notificationBean;
    
    @EJB
    private MonsterBean monsterBean;
    
    public byte[] getImage(Integer id) {
        return notificationBean.getOrder(id).getProof();
    }
    
    public byte[] getMonsterImage(Integer id) {
        return monsterBean.getMonsterById(id.toString()).getPhoto();
    }
    
}
