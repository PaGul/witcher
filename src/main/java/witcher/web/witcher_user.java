/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import witcher.ejbs.WitcherBean;
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
        if (!witcherBean.checkWitcherHasThisOrder(potentialOrder)) {
            return true;
        }
        return false;
    }
    
    public Boolean checkThisAdWitcherTake() {
        witcherordersPK potentialOrder = getPotentialOrder();
        if (witcherBean.checkWitcherHasThisOrder(potentialOrder) && !witcherBean.checkWitcherProveTheOrder(potentialOrder)) {
            return true;
        }
        return false;
    }

    public Boolean checkThisAdWitcherProve() {
        witcherordersPK potentialOrder = getPotentialOrder();
        if (witcherBean.checkWitcherProveTheOrder(potentialOrder)) {
            return true;
        }
        return false;
    }

    public void takeOrder() {
        witcherordersPK WitcherOrder = getPotentialOrder();
        witcherBean.addWitcherOrder(WitcherOrder);
    }

    public void cancelOrder() {
        witcherordersPK WitcherOrder = getPotentialOrder();
        witcherBean.deleteWitcherOrder(WitcherOrder);
    }

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() throws IOException {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            witcherordersPK WitcherOrder = getPotentialOrder();
            InputStream is = file.getInputstream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            witcherBean.proveOrder(WitcherOrder, buffer.toByteArray());
        }
    }
}
