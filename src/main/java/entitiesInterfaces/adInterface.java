/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitiesInterfaces;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pavelgulaev
 */
public interface adInterface extends Serializable {

    boolean equals(Object object);

    Date getAdDate();

    bestiaryInterface getBestiary();

    String getHeader();

    Integer getId();

    int getMonsterId();

    guestInterface getOwner();

    int getPrice();

    int getRating();

    String getText();

    int hashCode();

    void setAdDate(Date adDate);

    void setBestiary(bestiaryInterface bestiary);

    void setHeader(String header);

    void setId(Integer id);

    void setMonsterId(int monsterId);

    void setOwner(guestInterface owner);

    void setPrice(int price);

    void setRating(int rating);

    void setText(String text);

    String toString();
    
}
