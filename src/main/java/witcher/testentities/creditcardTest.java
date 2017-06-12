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
import javax.persistence.JoinColumn;
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
@Table(name = "CREDITCARD_TEST")
@XmlRootElement
public class creditcardTest implements creditcardInterface {
    @Id
    @SequenceGenerator(name = "CR_CARD_TEST_SEQ_GEN", sequenceName = "CR_CARD_TEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CR_CARD_TEST_SEQ_GEN")
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
    private guestTest guest;
    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private bankTest bank;

    public creditcardTest() {
        this.balance=0;
        this.bankId=1;
    }

    public creditcardTest(Integer id) {
        this.id = id;
        this.balance=0;
        this.bankId=1;
    }

    public creditcardTest(Integer id, int balance, int bankId) {
        this.id = id;
        this.balance = balance;
        this.bankId = bankId;
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
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBankId() {
        return bankId;
    }

    @Override
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Override
    public guestInterface getGuest() {
        return guest;
    }

    @Override
    public void setGuest(guestInterface guest) {
        this.guest = (guestTest) guest;
    }

    @Override
    public bankInterface getBank() {
        return bank;
    }

    @Override
    public void setBank(bankInterface bank) {
        this.bank = (bankTest) bank;
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
        if (!(object instanceof creditcardTest)) {
            return false;
        }
        creditcardTest other = (creditcardTest) object;
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
