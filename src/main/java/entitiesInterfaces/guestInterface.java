/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitiesInterfaces;

import java.io.Serializable;

/**
 *
 * @author pavelgulaev
 */
public interface guestInterface extends Serializable {

    boolean equals(Object object);

    int getCrCardId();

    creditcardInterface getCreditcard();

    String getEmail();

    Integer getId();

    String getLogin();

    String getName();

    String getPassword();

    int getRating();

    String getSecretanswer();

    String getSecretquestion();

    Integer getUserType();

    int hashCode();

    void setCrCardId(int crCardId);

    void setCreditcard(creditcardInterface creditcard);

    void setEmail(String email);

    void setId(Integer id);

    void setLogin(String login);

    void setName(String name);

    void setPassword(String password);

    void setRating(int rating);

    void setSecretanswer(String secretanswer);

    void setSecretquestion(String secretquestion);

    void setUserType(Integer userType);

    String toString();
    
}
