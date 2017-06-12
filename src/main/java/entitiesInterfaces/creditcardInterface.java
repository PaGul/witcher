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
public interface creditcardInterface extends Serializable {

    boolean equals(Object object);

    int getBalance();

    bankInterface getBank();

    int getBankId();

    guestInterface getGuest();

    Integer getId();

    int hashCode();

    void setBalance(int balance);

    void setBank(bankInterface bank);

    void setBankId(int bankId);

    void setGuest(guestInterface guest);

    void setId(Integer id);

    String toString();
    
}
