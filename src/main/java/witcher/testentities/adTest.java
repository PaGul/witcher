/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.testentities;

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
import entitiesInterfaces.*;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "AD_TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "adTest.findAll", query = "SELECT a FROM adTest a"),
    @NamedQuery(name = "adTest.findById", query = "SELECT a FROM adTest a WHERE a.id = :id"),
    @NamedQuery(name = "adTest.findByHeader", query = "SELECT a FROM adTest a WHERE a.header = :header"),
    @NamedQuery(name = "adTest.findByText", query = "SELECT a FROM adTest a WHERE a.text = :text"),
    @NamedQuery(name = "adTest.findByPrice", query = "SELECT a FROM adTest a WHERE a.price = :price"),
    @NamedQuery(name = "adTest.findByRating", query = "SELECT a FROM adTest a WHERE a.rating = :rating"),
    @NamedQuery(name = "adTest.findByAdDate", query = "SELECT a FROM adTest a WHERE a.adDate = :adDate"),
    @NamedQuery(name = "adTest.findByMonsterId", query = "SELECT a FROM adTest a WHERE a.monsterId = :monsterId")})
public class adTest implements adInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "AD_TEST_SEQ_GEN", sequenceName = "AD_TEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AD_TEST_SEQ_GEN")
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
    private bestiaryTest bestiary;
    @JoinColumn(name = "OWNER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private guestTest owner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId")
    private Collection<witcherordersTest> witcherordersCollection;

    public adTest() {
    }

    public adTest(Integer id) {
        this.id = id;
    }

    public adTest(Integer id, String header, String text, int price, int rating, Date adDate, int monsterId) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.price = price;
        this.rating = rating;
        this.adDate = adDate;
        this.monsterId = monsterId;
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
    public String getHeader() {
        return header;
    }

    @Override
    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public Date getAdDate() {
        return adDate;
    }

    @Override
    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    @Override
    public int getMonsterId() {
        return monsterId;
    }

    @Override
    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    @Override
    public bestiaryInterface getBestiary() {
        return bestiary;
    }

    @Override
    public void setBestiary(bestiaryInterface bestiary) {
        this.bestiary = (bestiaryTest) bestiary;
    }

    @Override
    public guestInterface getOwner() {
        return owner;
    }

    @Override
    public void setOwner(guestInterface owner) {
        this.owner = (guestTest) owner;
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
        if (!(object instanceof adTest)) {
            return false;
        }
        adTest other = (adTest) object;
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
