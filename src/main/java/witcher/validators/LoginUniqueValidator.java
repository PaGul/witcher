/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import witcher.ejbs.GuestBean;

/**
 *
 * @author pavelgulaev
 */


@FacesValidator("loginUniqueValidator")
    public class LoginUniqueValidator implements Validator {

    @EJB
    private GuestBean guestBean;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String login = (String) value;
        if (guestBean.hasUserWithLogin(login)) {
            throw new ValidatorException(new FacesMessage("Already has user with this login!"));
        }
    }

}