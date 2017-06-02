/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "AD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ad.findAll", query = "SELECT a FROM ad a"),
    @NamedQuery(name = "ad.findById", query = "SELECT a FROM ad a WHERE a.id = :id"),
    @NamedQuery(name = "ad.findByHeader", query = "SELECT a FROM ad a WHERE a.header = :header"),
    @NamedQuery(name = "ad.findByText", query = "SELECT a FROM ad a WHERE a.text = :text"),
    @NamedQuery(name = "ad.findByPrice", query = "SELECT a FROM ad a WHERE a.price = :price"),
    @NamedQuery(name = "ad.findByRating", query = "SELECT a FROM ad a WHERE a.rating = :rating"),
    @NamedQuery(name = "ad.findByAdDate", query = "SELECT a FROM ad a WHERE a.adDate = :adDate"),
    @NamedQuery(name = "ad.findByMonsterId", query = "SELECT a FROM ad a WHERE a.monsterId = :monsterId")})
public class ad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "AD_SEQ_GEN", sequenceName = "AD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AD_SEQ_GEN")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ad_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONSTER_ID")
    private int monsterId;
    @JoinColumn(name = "MONSTER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private bestiary bestiary;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private guest owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId")
    private Collection<witcherorders> witcherordersCollection;

    public ad() {
    }

    public ad(Integer id) {
        this.id = id;
    }

    public ad(Integer id, String header, String text, int price, int rating, Date adDate, int monsterId) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.price = price;
        this.rating = rating;
        this.adDate = adDate;
        this.monsterId = monsterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public bestiary getBestiary() {
        return bestiary;
    }

    public void setBestiary(bestiary bestiary) {
        this.bestiary = bestiary;
    }

    public guest getOwner() {
        return owner;
    }

    public void setOwner(guest owner) {
        this.owner = owner;
    }

    @XmlTransient
    public Collection<witcherorders> getWitcherordersCollection() {
        return witcherordersCollection;
    }

    public void setWitcherordersCollection(Collection<witcherorders> witcherordersCollection) {
        this.witcherordersCollection = witcherordersCollection;
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
