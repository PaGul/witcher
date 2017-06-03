package witcher.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.context.RequestContext;
import witcher.ejbs.GuestBean;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@FacesValidator("signUpSecretQuestion")
public class SignUpHasSecretQuestion implements Validator {

    @EJB
    private GuestBean guestBean;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        HtmlInputText text = (HtmlInputText) FacesContext.getCurrentInstance().getViewRoot().findComponent("j_idt21:squestion");
        if (text==null) {
            throw new ValidatorException(new FacesMessage("Program has error.Sorry"));
        }
        String question = (String) text.getValue();
        String answer = (String) value;
        if ((question==null || question.length()<1 || question.length()>15) ^ (answer==null || answer.length()<1 || answer.length()>15)) {
            throw new ValidatorException(new FacesMessage("Secret question is not required field.\n Secret question and secret answer lengths should be in range (1-15)"));
        }
    }

}
