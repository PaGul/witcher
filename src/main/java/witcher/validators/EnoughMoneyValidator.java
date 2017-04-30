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


@FacesValidator("enoughMoney")
    public class EnoughMoneyValidator implements Validator {

    @EJB
    private GuestBean guestBean;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer money = (Integer) value;
        Integer balance = SessionUtils.getUser().getBalance();
        if (money>balance) {
            throw new ValidatorException(new FacesMessage("You haven't enough money. Your balance is "+balance));
        }
    }

}