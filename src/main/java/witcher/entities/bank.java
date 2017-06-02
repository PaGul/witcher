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
@Table(name = "BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "bank.findAll", query = "SELECT b FROM bank b"),
    @NamedQuery(name = "bank.findById", query = "SELECT b FROM bank b WHERE b.id = :id"),
    @NamedQuery(name = "bank.findByCommision", query = "SELECT b FROM bank b WHERE b.commision = :commision"),
    @NamedQuery(name = "bank.findByName", query = "SELECT b FROM bank b WHERE b.name = :name")})
public class bank implements Serializable {
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
    private creditcard creditcard;

    public bank() {
    }

    public bank(Long id) {
        this.id = id;
    }

    public bank(Long id, double commision, String name) {
        this.id = id;
        this.commision = commision;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(creditcard creditcard) {
        this.creditcard = creditcard;
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
        if (!(object instanceof bank)) {
            return false;
        }
        bank other = (bank) object;
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
