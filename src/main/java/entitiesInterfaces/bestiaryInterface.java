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
public interface bestiaryInterface extends Serializable {

    boolean equals(Object object);

    adInterface getAd();

    String getDescription();

    Integer getId();

    String getName();

    byte[] getPhoto();

    int hashCode();

    void setAd(adInterface ad);

    void setDescription(String description);

    void setId(Integer id);

    void setName(String name);

    void setPhoto(byte[] photo);

    String toString();
    
}
