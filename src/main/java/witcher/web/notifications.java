/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import witcher.ejbs.AdBean;
import witcher.ejbs.NotificationBean;
import witcher.entities.guest;
import witcher.entities.witcherorders;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@SessionScoped
@ManagedBean(name = "notifications")
public class notifications implements Serializable {

    @EJB
    private NotificationBean notificationBean;
    @EJB
    private AdBean adBean;
    private List<witcherorders> notificatedOrders;

    public List<witcherorders> getNotificatedOrders() {
        guest Customer = SessionUtils.getUser();
        notificatedOrders = notificationBean.getNewNotificatedOrders(Customer);
        return notificatedOrders;
    }

    public void setNotificatedOrders(List<witcherorders> notificatedOrders) {
        this.notificatedOrders = notificatedOrders;
    }

    private witcherorders selectedOrder;

    public witcherorders getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(witcherorders selectedOrder) {
        System.out.println("selected" + selectedOrder.getId());
        this.selectedOrder = selectedOrder;
    }

    public void showImg(witcherorders order) {
        this.selectedOrder = order;
        RequestContext.getCurrentInstance().update("imgForm:imgDlg");
        RequestContext.getCurrentInstance().execute("PF('dlg').show()");
    }

    public void pay(witcherorders order) {
        if (adBean.pay(order)) {
            FacesMessage message = new FacesMessage("Successful payment");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("Error payment (probably you haven't enough money)");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
