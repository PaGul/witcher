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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pavelgulaev
 */
@Entity
@Table(name = "guest")
@NamedQueries({
    @NamedQuery(name = "guest.findAll", query = "SELECT g FROM guest g")})
public class guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany(mappedBy = "guestCollection")
    private Collection<ad> adCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Collection<ad> adCollection1;

    public guest() {
    }

    public guest(Integer id) {
        this.id = id;
    }

    public guest(String login, String password, String email, String name, int userType) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userType = userType;
    }

    public guest(Integer id, String login, String password, String email, String name, int userType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userType = userType;
    }

    public guest(String login, String password, String email, String name, int userType, String secretquestion, String secretanswer) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.userType = userType;
        this.secretquestion = secretquestion;
        this.secretanswer = secretanswer;
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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

    public Collection<ad> getAdCollection() {
        return adCollection;
    }

    public void setAdCollection(Collection<ad> adCollection) {
        this.adCollection = adCollection;
    }

    public Collection<ad> getAdCollection1() {
        return adCollection1;
    }

    public void setAdCollection1(Collection<ad> adCollection1) {
        this.adCollection1 = adCollection1;
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
