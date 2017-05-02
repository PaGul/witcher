/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "witcherorders.findByNotificated", query = "SELECT w FROM witcherorders w WHERE w.notificated = :notificated"),
    @NamedQuery(name = "witcherorders.findById", query = "SELECT w FROM witcherorders w WHERE w.id = :id"),
    @NamedQuery(name = "witcherorders.findByWitcherAndAd", query = "SELECT w FROM witcherorders w WHERE w.witcherId = :wid AND w.adId=:aid")})

public class witcherorders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificated")
    private int notificated;
    @Lob
    @Column(name = "proof")
    private byte[] proof;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ad adId;
    @JoinColumn(name = "witcher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private guest witcherId;

    public witcherorders() {
    }

    public witcherorders(Long id) {
        this.id = id;
    }

    public witcherorders(Long id, int notificated) {
        this.id = id;
        this.notificated = notificated;
    }

    public witcherorders(guest witcherId, ad adId) {
        this.adId = adId;
        this.witcherId = witcherId;
    }

    
    public int getNotificated() {
        return notificated;
    }

    public void setNotificated(int notificated) {
        this.notificated = notificated;
    }

    public byte[] getProof() {
        return proof;
    }

    public void setProof(byte[] proof) {
        this.proof = proof;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ad getAdId() {
        return adId;
    }

    public void setAdId(ad adId) {
        this.adId = adId;
    }

    public guest getWitcherId() {
        return witcherId;
    }

    public void setWitcherId(guest witcherId) {
        this.witcherId = witcherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof witcherorders)) {
            return false;
        }
        witcherorders other = (witcherorders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.witcherorders[ id=" + id + " ]";
    }
    
    public Boolean getProofed() {
        return getProof()!=null;
                
    }
    
}
