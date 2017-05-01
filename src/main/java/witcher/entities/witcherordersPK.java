/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pavelgulaev
 */
@Embeddable
public class witcherordersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "witcher_id")
    private int witcherId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ad_id")
    private int adId;

    public witcherordersPK() {
    }

    public witcherordersPK(int witcherId, int adId) {
        this.witcherId = witcherId;
        this.adId = adId;
    }

    public int getWitcherId() {
        return witcherId;
    }

    public void setWitcherId(int witcherId) {
        this.witcherId = witcherId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) witcherId;
        hash += (int) adId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof witcherordersPK)) {
            return false;
        }
        witcherordersPK other = (witcherordersPK) object;
        if (this.witcherId != other.witcherId) {
            return false;
        }
        if (this.adId != other.adId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.witcherordersPK[ witcherId=" + witcherId + ", adId=" + adId + " ]";
    }
    
}
