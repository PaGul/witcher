/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
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
    
//    private String notificationType = "Only new";
    private String notificationType = "All";

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
    
    public void makeAllOld() {
        guest Customer = SessionUtils.getUser();
        notificationBean.makeThemOld(Customer);
    }
    

    public List<witcherorders> getNotificatedOrders() {
        guest Customer = SessionUtils.getUser();
        if (notificationType.equals("Only new")) {
            notificatedOrders = notificationBean.getNewNotificatedOrders(Customer);
        } else {
            notificatedOrders = notificationBean.getAllOrders(Customer);
        }
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
        this.selectedOrder = selectedOrder;
    }

    public void showImg(witcherorders order) {
        this.selectedOrder = order;
        RequestContext.getCurrentInstance().update("imgForm:imgDlg");
        RequestContext.getCurrentInstance().execute("PF('dlg').show()");
    }

}
