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
    
    public byte[] getImage(Integer id) {
//        byte[] proof = notificationBean.getOrder(WitcherOrderId).getProof();
//        if (proof==null) {
//            proof = notificationBean.getOrder(9l).getProof();
//        }
        return notificationBean.getOrder(id).getProof();
    }
    
}
