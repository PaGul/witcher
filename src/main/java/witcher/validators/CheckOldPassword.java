package witcher.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import witcher.ejbs.GuestBean;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */


@FacesValidator("checkOldPassword")
    public class CheckOldPassword implements Validator {

    @EJB
    private GuestBean guestBean;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        String oldPassword = SessionUtils.getUser().getPassword();
        if (!oldPassword.equals(password)) {
            throw new ValidatorException(new FacesMessage("You forget your old password"));
        }
    }

}