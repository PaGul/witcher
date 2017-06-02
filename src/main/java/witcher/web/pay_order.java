/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import witcher.ejbs.AdBean;
import witcher.ejbs.BankBean;
import witcher.entities.ad;
import witcher.entities.witcherorders;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class pay_order implements Serializable {
    @EJB
    private BankBean bankBean;
    
    
    public void pay(witcherorders order) {
        if (bankBean.pay(order)) {
            FacesMessage message = new FacesMessage("Successful payment");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("Error payment (probably you haven't enough money)");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   
    public void reject(witcherorders order) {
        bankBean.rejectComplitedOrder(order);
    }
    
}
