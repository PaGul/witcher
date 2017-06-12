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
public interface witcherordersInterface extends Serializable {

    boolean equals(Object object);

    adInterface getAdId();

    Integer getId();

    int getNotificated();

    byte[] getProof();

    Boolean getProofed();

    guestInterface getWitcherId();

    int hashCode();

    void setAdId(adInterface adId);

    void setId(Integer id);

    void setNotificated(Integer notificated);

    void setProof(byte[] proof);

    void setWitcherId(guestInterface witcherId);

    String toString();
    
}
