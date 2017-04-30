/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "ad")
@NamedQueries({
    @NamedQuery(name = "ad.findAll", query = "SELECT a FROM ad a")})
public class ad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "header")
    private String header;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinTable(name = "adowners", joinColumns = {
        @JoinColumn(name = "adid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<guest> guestCollection;
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private guest owner;

    public ad() {
    }

    public ad(Long id) {
        this.id = id;
    }

    public ad(Long id, String header, String text, int price) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Collection<guest> getGuestCollection() {
        return guestCollection;
    }

    public void setGuestCollection(Collection<guest> guestCollection) {
        this.guestCollection = guestCollection;
    }

    public guest getOwner() {
        return owner;
    }

    public void setOwner(guest owner) {
        this.owner = owner;
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
        if (!(object instanceof ad)) {
            return false;
        }
        ad other = (ad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.ad[ id=" + id + " ]";
    }
    
}
