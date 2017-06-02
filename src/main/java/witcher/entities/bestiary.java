/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "BESTIARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "bestiary.findAll", query = "SELECT b FROM bestiary b"),
    @NamedQuery(name = "bestiary.findById", query = "SELECT b FROM bestiary b WHERE b.id = :id"),
    @NamedQuery(name = "bestiary.findByName", query = "SELECT b FROM bestiary b WHERE b.name = :name"),
    @NamedQuery(name = "bestiary.findByDescription", query = "SELECT b FROM bestiary b WHERE b.description = :description")})
public class bestiary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "BESTIARY_SEQ_GEN", sequenceName = "BESTIARY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BESTIARY_SEQ_GEN")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(min = 1, max = 2147483647)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bestiary")
    private ad ad;

    public bestiary() {
    }

    public bestiary(Integer id) {
        this.id = id;
    }

    public bestiary(Integer id, String description, byte[] photo) {
        this.id = id;
        this.description = description;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public ad getAd() {
        return ad;
    }

    public void setAd(ad ad) {
        this.ad = ad;
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
        if (!(object instanceof bestiary)) {
            return false;
        }
        bestiary other = (bestiary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.bestiary[ id=" + id + " ]";
    }

}
