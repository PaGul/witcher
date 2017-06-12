/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import entitiesInterfaces.*;
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
import javax.persistence.SequenceGenerator;
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

public class witcherorders implements witcherordersInterface {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificated")
    private Integer notificated;
    @Lob
    @Column(name = "proof")
    private byte[] proof;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "WO_SEQ_GEN", sequenceName = "WO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WO_SEQ_GEN")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "ad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ad adId;
    @JoinColumn(name = "witcher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private guest witcherId;

    public witcherorders() {
    }

    public witcherorders(Integer id) {
        this.id = id;
    }

    public witcherorders(Integer id, Integer notificated) {
        this.id = id;
        this.notificated = notificated;
    }

    public witcherorders(guest witcherId, ad adId) {
        this.adId = adId;
        this.witcherId = witcherId;
        this.notificated = 0;
    }

    
    @Override
    public int getNotificated() {
        return notificated;
    }

    @Override
    public void setNotificated(Integer notificated) {
        this.notificated = notificated;
    }

    @Override
    public byte[] getProof() {
        return proof;
    }

    @Override
    public void setProof(byte[] proof) {
        this.proof = proof;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public adInterface getAdId() {
        return adId;
    }

    @Override
    public void setAdId(adInterface adId) {
        this.adId = (ad) adId;
    }

    @Override
    public guestInterface getWitcherId() {
        return witcherId;
    }

    @Override
    public void setWitcherId(guestInterface witcherId) {
        this.witcherId = (guest) witcherId;
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
    
    @Override
    public Boolean getProofed() {
        return getProof()!=null;
                
}
    
}
