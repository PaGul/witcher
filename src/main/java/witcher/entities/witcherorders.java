/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "witcherorders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "witcherorders.findAll", query = "SELECT w FROM witcherorders w"),
    @NamedQuery(name = "witcherorders.findByWitcherId", query = "SELECT w FROM witcherorders w WHERE w.witcherordersPK.witcherId = :witcherId"),
    @NamedQuery(name = "witcherorders.findByAdId", query = "SELECT w FROM witcherorders w WHERE w.witcherordersPK.adId = :adId"),
    @NamedQuery(name = "witcherorders.findByNotificated", query = "SELECT w FROM witcherorders w WHERE w.notificated = :notificated")})
public class witcherorders implements Serializable {
    @Lob
    @Column(name = "proof")
    private byte[] proof;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected witcherordersPK witcherordersPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificated")
    private int notificated;
    @JoinColumn(name = "ad_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ad ad;
    @JoinColumn(name = "witcher_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private guest guest;

    public witcherorders() {
    }

    public witcherorders(witcherordersPK witcherordersPK) {
        this.witcherordersPK = witcherordersPK;
    }

    public witcherorders(witcherordersPK witcherordersPK, int notificated) {
        this.witcherordersPK = witcherordersPK;
        this.notificated = notificated;
    }

    public witcherorders(int witcherId, int adId) {
        this.witcherordersPK = new witcherordersPK(witcherId, adId);
    }

    public witcherordersPK getWitcherordersPK() {
        return witcherordersPK;
    }

    public void setWitcherordersPK(witcherordersPK witcherordersPK) {
        this.witcherordersPK = witcherordersPK;
    }

    public int getNotificated() {
        return notificated;
    }

    public void setNotificated(int notificated) {
        this.notificated = notificated;
    }

    public ad getAd() {
        return ad;
    }

    public void setAd(ad ad) {
        this.ad = ad;
    }

    public guest getGuest() {
        return guest;
    }

    public void setGuest(guest guest) {
        this.guest = guest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (witcherordersPK != null ? witcherordersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof witcherorders)) {
            return false;
        }
        witcherorders other = (witcherorders) object;
        if ((this.witcherordersPK == null && other.witcherordersPK != null) || (this.witcherordersPK != null && !this.witcherordersPK.equals(other.witcherordersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.witcherorders[ witcherordersPK=" + witcherordersPK + " ]";
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }
    
}
