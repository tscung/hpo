package sg.com.stellarstudios.imser.web.struts.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.common.WebUtility;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PnPInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = WebUtility.getInstance().getServletRequest(actionInvocation.getInvocationContext());
	    HttpServletResponse response = WebUtility.getInstance().getServletResponse(actionInvocation.getInvocationContext());

	    HttpSession session =  request.getSession(true);	    
		User user = (User) session.getAttribute(WebKeys.USER_OBJECT_PRINCIPAL);
		
		if (user.getUserRegistration().getCompletedEvaluation() != null && user.getUserRegistration().getCompletedEvaluation()) {
		    return actionInvocation.invoke();
		}
		else {
			response.sendRedirect(request.getContextPath()+"/restricted/preloadEvaluationFormUserRegistration." + WebKeys.ACTION_EXTENSION + "?id=" + user.getUserRegistration().getId());
			return null;
		}
			
	}
}
