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


@FacesValidator("hasUserValidator")
    public class HasUserValidator implements Validator {

    @EJB
    private GuestBean guestBean;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String login = (String) value;
        if (!guestBean.hasUserWithLogin(login)) {
            throw new ValidatorException(new FacesMessage("No user with this login!"));
        }
    }

}