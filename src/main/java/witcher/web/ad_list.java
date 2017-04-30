/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private List<ad> ads;
    private List<ad> filteredAds;

    /**
     * Creates a new instance of ad_list
     */
    public ad_list() {
    }
    @PostConstruct
    public void init() {
        ads = adBean.getAds();
    }
    
    public List<ad> getAds() {
        return ads;
    }

    public void setAds(List<ad> ads) {
        this.ads = ads;
    }

    public List<ad> getFilteredAds() {
        return filteredAds;
    }

    public void setFilteredAds(List<ad> filteredAds) {
        this.filteredAds = filteredAds;
    }
    
    
}
