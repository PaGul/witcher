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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "CREDITCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "creditcard.findAll", query = "SELECT c FROM creditcard c"),
    @NamedQuery(name = "creditcard.findById", query = "SELECT c FROM creditcard c WHERE c.id = :id"),
    @NamedQuery(name = "creditcard.findByBalance", query = "SELECT c FROM creditcard c WHERE c.balance = :balance"),
    @NamedQuery(name = "creditcard.findByBankId", query = "SELECT c FROM creditcard c WHERE c.bankId = :bankId")})
public class creditcard implements Serializable {
    @Id
    @SequenceGenerator(name = "CR_CARD_SEQ_GEN", sequenceName = "CR_CARD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CR_CARD_SEQ_GEN")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private int balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_ID")
    private int bankId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "creditcard")
    private guest guest;
    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private bank bank;

    public creditcard() {
        this.balance=0;
        this.bankId=1;
    }

    public creditcard(Integer id) {
        this.id = id;
        this.balance=0;
        this.bankId=1;
    }

    public creditcard(Integer id, int balance, int bankId) {
        this.id = id;
        this.balance = balance;
        this.bankId = bankId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof creditcard)) {
            return false;
        }
        creditcard other = (creditcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.creditcard[ id=" + id + " ]";
    }
    
}
