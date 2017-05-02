/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import witcher.ejbs.NotificationBean;
import witcher.entities.guest;
import witcher.entities.witcherorders;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@RequestScoped
@ManagedBean
public class notifications {
    @EJB
    private NotificationBean notificationBean;
    private List<witcherorders> notificatedOrders;
    @PostConstruct
    public void init() {
        guest Customer = SessionUtils.getUser();
        notificatedOrders = notificationBean.getNewNotificatedOrders(Customer);
    }

    public List<witcherorders> getNotificatedOrders() {
        return notificatedOrders;
    }

    public void setNotificatedOrders(List<witcherorders> notificatedOrders) {
        this.notificatedOrders = notificatedOrders;
    }
    
//    public StreamedContent getImageFromDB(witcherorders WitcherOrder) throws IOException {
//        
//        if (WitcherOrder==null) {
//            System.out.println("This is null");
//            return new DefaultStreamedContent();
//        } else {
//		FacesContext context = FacesContext.getCurrentInstance();
// 
//		if ((context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)) {
//                    System.out.println(WitcherOrder);
//			return new DefaultStreamedContent();
//		} else {
//                        
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
// 
//			byte[] image = WitcherOrder.getProof();
// 
//			return new DefaultStreamedContent(new ByteArrayInputStream(image),"image/jpg","test.jpg");
// 
//		}
//        }
//	}
    
}
