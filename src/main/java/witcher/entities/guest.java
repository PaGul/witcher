/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "GUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "guest.findAll", query = "SELECT g FROM guest g"),
    @NamedQuery(name = "guest.findById", query = "SELECT g FROM guest g WHERE g.id = :id"),
    @NamedQuery(name = "guest.findByLogin", query = "SELECT g FROM guest g WHERE g.login = :login"),
    @NamedQuery(name = "guest.findByPassword", query = "SELECT g FROM guest g WHERE g.password = :password"),
    @NamedQuery(name = "guest.findByLoginAndPassword", query = "SELECT g FROM guest g WHERE g.login = :login and g.password = :password"),
    @NamedQuery(name = "guest.findByEmail", query = "SELECT g FROM guest g WHERE g.email = :email"),
    @NamedQuery(name = "guest.findByName", query = "SELECT g FROM guest g WHERE g.name = :name"),
    @NamedQuery(name = "guest.findByUserType", query = "SELECT g FROM guest g WHERE g.userType = :userType"),
    @NamedQuery(name = "guest.findBySecretquestion", query = "SELECT g FROM guest g WHERE g.secretquestion = :secretquestion"),
    @NamedQuery(name = "guest.findBySecretanswer", query = "SELECT g FROM guest g WHERE g.secretanswer = :secretanswer"),
    @NamedQuery(name = "guest.findByRating", query = "SELECT g FROM guest g WHERE g.rating = :rating"),
    @NamedQuery(name = "guest.findByCrCardId", query = "SELECT g FROM guest g WHERE g.crCardId = :crCardId")})
public class guest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "GUEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_type")
    private int userType;
    @Size(max = 2147483647)
    @Column(name = "secretquestion")
    private String secretquestion;
    @Size(max = 2147483647)
    @Column(name = "secretanswer")
    private String secretanswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CR_CARD_ID")
    private int crCardId;
    @JoinColumn(name = "CR_CARD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private creditcard creditcard;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Collection<ad> adCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "guest")
    private customer customer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "guest")
    private witcher witcher;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "witcherId")
    private Collection<witcherorders> witcherordersCollection;

    public guest() {
        this.rating = 0;
    }

    public guest(Integer id) {
        this.id = id;
    }

    public guest(Integer id, String login, String password, String email, String name, int userType, int rating, int crCardId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userType = userType;
        this.rating = rating;
        this.crCardId = crCardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getSecretquestion() {
        return secretquestion;
    }

    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }

    public String getSecretanswer() {
        return secretanswer;
    }

    public void setSecretanswer(String secretanswer) {
        this.secretanswer = secretanswer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCrCardId() {
        return crCardId;
    }

    public void setCrCardId(int crCardId) {
        this.crCardId = crCardId;
    }

    public creditcard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(creditcard creditcard) {
        this.creditcard = creditcard;
    }

    @XmlTransient
    public Collection<ad> getAdCollection() {
        return adCollection;
    }

    public void setAdCollection(Collection<ad> adCollection) {
        this.adCollection = adCollection;
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
        if (!(object instanceof guest)) {
            return false;
        }
        guest other = (guest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "witcher.entities.guest[ id=" + id + " ]";
    }
    
}
