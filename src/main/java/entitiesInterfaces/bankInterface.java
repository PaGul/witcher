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
public interface bankInterface extends Serializable {

    boolean equals(Object object);

    double getCommision();

    creditcardInterface getCreditcard();

    Long getId();

    String getName();

    int hashCode();

    void setCommision(double commision);

    void setCreditcard(creditcardInterface creditcard);

    void setId(Long id);

    void setName(String name);

    String toString();
    
}
