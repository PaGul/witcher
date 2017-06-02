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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "WITCHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "witcher.findAll", query = "SELECT w FROM witcher w"),
    @NamedQuery(name = "witcher.findByGuestId", query = "SELECT w FROM witcher w WHERE w.guestId = :guestId"),
    @NamedQuery(name = "witcher.findByHasHorse", query = "SELECT w FROM witcher w WHERE w.hasHorse = :hasHorse")})
public class witcher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GUEST_ID")
    private Integer guestId;
    @Column(name = "HAS_HORSE")
    private Short hasHorse;
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private guest guest;

    public witcher() {
    }

    public witcher(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Short getHasHorse() {
        return hasHorse;
    }

    public void setHasHorse(Short hasHorse) {
        this.hasHorse = hasHorse;
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
        hash += (guestId != null ? guestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof witcher)) {
            return false;
        }
        witcher other = (witcher) object;
        if ((this.guestId == null && other.guestId != null) || (this.guestId != null && !this.guestId.equals(other.guestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.witcher[ guestId=" + guestId + " ]";
    }
    
}
