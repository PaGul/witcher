/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import witcher.ejbs.AdBean;
import witcher.ejbs.GuestBean;
import witcher.ejbs.WitcherBean;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.entities.witcherorders;
import witcher.entities.witcherordersPK;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@SessionScoped
public class witcher_user extends guest_instance {

    public witcher_user() {
    }

    @EJB
    private WitcherBean witcherBean;

    private String getAdQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adquery");
    }

    private witcherordersPK getPotentialOrder() {
        String query = getAdQuery();
        Integer adId = Integer.parseInt(query);
        Integer witcherId = SessionUtils.getUserId();
        witcherordersPK potentialOrder = new witcherordersPK(witcherId, adId);
        return potentialOrder;
    }

    public Boolean getWitcherLoggedSession() {
        if (SessionUtils.getUser() != null && SessionUtils.getUser().getUserType() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkThisAdWitcherDontTake() {
        witcherordersPK potentialOrder = getPotentialOrder();
        if (witcherBean.checkWitcherHasThisOrder(potentialOrder)) {
            return false;
        }
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("adId", potentialOrder.getAdId());
        return true;

    }
    
      public Boolean checkThisAdWitcherTake() {
        witcherordersPK potentialOrder = getPotentialOrder();
        if (!witcherBean.checkWitcherHasThisOrder(potentialOrder)) {
            return false;
        }
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("adId", potentialOrder.getAdId());
        return true;
    }

    public void takeOrder() {
        HttpSession session = SessionUtils.getSession();
        Integer adId = (Integer) session.getAttribute("adId");
        witcherorders WitcherOrder = new witcherorders(getMyId(), adId);
        witcherBean.addWitcherOrder(WitcherOrder);
        session.removeAttribute("ad");
    }

    public void cancelOrder() {
        HttpSession session = SessionUtils.getSession();
        Integer adId = (Integer) session.getAttribute("adId");
        witcherordersPK WitcherOrder = new witcherordersPK(getMyId(), adId);
        witcherBean.deleteWitcherOrder(WitcherOrder);
        session.removeAttribute("ad");
    }
}
