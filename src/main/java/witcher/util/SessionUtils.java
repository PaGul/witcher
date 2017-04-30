package witcher.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import witcher.entities.guest;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return (String) session.getAttribute("username");
	}

	public static Integer getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (Integer) session.getAttribute("userid");
		else
			return null;
	}
        
        public static Integer getUserType() {
		HttpSession session = getSession();
		if (session != null)
			return (Integer) session.getAttribute("userType");
		else
			return null;
	}
}
