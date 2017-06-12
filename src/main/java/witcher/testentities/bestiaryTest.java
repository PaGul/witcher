/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package witcher.testentities;

import entitiesInterfaces.*;
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
@Table(name = "BESTIARY_TEST")
@XmlRootElement
public class bestiaryTest implements bestiaryInterface {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "BESTIARY_TEST_SEQ_GEN", sequenceName = "BESTIARY_TEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BESTIARY_TEST_SEQ_GEN")
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
    private adTest ad;

    public bestiaryTest() {
    }

    public bestiaryTest(Integer id) {
        this.id = id;
    }

    public bestiaryTest(Integer id, String description, byte[] photo) {
        this.id = id;
        this.description = description;
        this.photo = photo;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public byte[] getPhoto() {
        return photo;
    }

    @Override
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public adInterface getAd() {
        return ad;
    }

    @Override
    public void setAd(adInterface ad) {
        this.ad = (adTest) ad;
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
        if (!(object instanceof bestiaryTest)) {
            return false;
        }
        bestiaryTest other = (bestiaryTest) object;
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
