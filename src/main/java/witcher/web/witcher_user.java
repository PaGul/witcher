/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import witcher.ejbs.AdBean;
import witcher.ejbs.WitcherBean;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.entities.witcher;
import witcher.entities.witcherorders;
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
    @EJB
    private AdBean adBean;
    
    private String getAdQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adquery");
    }

    private witcherorders getPotentialOrder() {
        String query = getAdQuery();
        ad adById = adBean.getAdById(query);
        guest witcher = SessionUtils.getUser();
        witcherorders potentialOrder = new witcherorders(witcher, adById);
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
        witcherorders potentialOrder = getPotentialOrder();
        if (!witcherBean.checkWitcherHasThisOrder(potentialOrder)) {
            return true;
        }
        return false;
    }

    public Boolean checkThisAdWitcherTake() {
        witcherorders potentialOrder = getPotentialOrder();
        if (witcherBean.checkWitcherHasThisOrder(potentialOrder) && !witcherBean.checkWitcherProveTheOrder(potentialOrder)) {
            return true;
        }
        return false;
    }

    public Boolean checkThisAdWitcherProve() {
        witcherorders potentialOrder = getPotentialOrder();
        if (witcherBean.checkWitcherProveTheOrder(potentialOrder)) {
            return true;
        }
        return false;
    }

    public void takeOrder() {
        witcherorders WitcherOrder = getPotentialOrder();
        witcherBean.addWitcherOrder(WitcherOrder);
    }

    public void cancelOrder() {
        witcherorders WitcherOrder = getPotentialOrder();
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
            witcherorders WitcherOrder = getPotentialOrder();
            InputStream is = file.getInputstream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();
            if (buffer.size() != 0) {
                FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded." + file.getContentType());
                FacesContext.getCurrentInstance().addMessage(null, message);
                witcherBean.proveOrder(WitcherOrder, buffer.toByteArray());
            } else {
                FacesMessage message = new FacesMessage("Uploading error file" + file.getContentType());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    }
    
    private witcher additionalParams = new witcher(SessionUtils.getUserId());

    public witcher getAdditionalParams() {
        return additionalParams;
    }

    public void setAdditionalParams(witcher additionalParams) {
        this.additionalParams = additionalParams;
    }
    
    public String addInfoAboutHorse() {
        witcherBean.addInfoAboutHorse(additionalParams);
        return "index";
    }
}
