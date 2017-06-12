/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.testentities;

import entitiesInterfaces.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "BANK_TEST")
@XmlRootElement
public class bankTest implements bankInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMISION")
    private double commision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "NAME")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bank")
    private creditcardTest creditcard;

    public bankTest() {
    }

    public bankTest(Long id) {
        this.id = id;
    }

    public bankTest(Long id, double commision, String name) {
        this.id = id;
        this.commision = commision;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public double getCommision() {
        return commision;
    }

    @Override
    public void setCommision(double commision) {
        this.commision = commision;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public creditcardInterface getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(creditcardInterface creditcard) {
        this.creditcard = (creditcardTest) creditcard;
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
        if (!(object instanceof bankTest)) {
            return false;
        }
        bankTest other = (bankTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.bank[ id=" + id + " ]";
    }
    
}
