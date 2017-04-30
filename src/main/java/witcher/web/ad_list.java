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
import javax.faces.bean.RequestScoped;
import witcher.ejbs.AdBean;
import witcher.entities.ad;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class ad_list implements Serializable {
    
    @EJB
    private AdBean adBean;

    /**
     * Creates a new instance of ad_list
     */
    public ad_list() {
    }
    
    public List<ad> getAds() {
        return adBean.getAds();
    }
    
}
