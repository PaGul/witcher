package witcher.util;

import entitiesInterfaces.guestInterface;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import witcher.entities.guest;
import witcher.testentities.guestTest;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
        
        public static HttpSession getNewSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static Integer getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (Integer) session.getAttribute("userid");
		else
			return null;
	}
        
        
        
        public static guest getUser() {
		HttpSession session = getSession();
		if (session != null)
			return (guest) session.getAttribute("user");
		else
			return null;
	}
        
        public static guestInterface getUserObject() {
		HttpSession session = getSession();
		if (session != null)
			return (guestInterface) session.getAttribute("user");
		else
			return null;
	}
}
