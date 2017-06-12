/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.entities;

import entitiesInterfaces.*;
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
public class guest implements guestInterface {
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
    private Collection<witcherorders> witcherordersInterfaceCollection;

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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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
    public Integer getUserType() {
        return userType;
    }

    @Override
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String getSecretquestion() {
        return secretquestion;
    }

    @Override
    public void setSecretquestion(String secretquestion) {
        this.secretquestion = secretquestion;
    }

    @Override
    public String getSecretanswer() {
        return secretanswer;
    }

    @Override
    public void setSecretanswer(String secretanswer) {
        this.secretanswer = secretanswer;
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
    public int getCrCardId() {
        return crCardId;
    }

    @Override
    public void setCrCardId(int crCardId) {
        this.crCardId = crCardId;
    }

    @Override
    public creditcardInterface getCreditcard() {
        return creditcard;
    }

    @Override
    public void setCreditcard(creditcardInterface creditcard) {
        this.creditcard = (creditcard) creditcard;
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
