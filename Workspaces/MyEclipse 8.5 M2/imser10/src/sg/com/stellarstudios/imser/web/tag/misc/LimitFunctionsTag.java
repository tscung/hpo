package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class LimitFunctionsTag extends BaseTag {
    private String modules;

    public int doStartTag() throws JspException {
        //calls doInitBody()
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpSession session = request.getSession(false);

        //get user
        User user = (User) session.getAttribute(WebKeys.USER_OBJECT_PRINCIPAL);
        if (user != null) {
        	//if modules match, print out bodycontent
        	boolean print = false;
        	StringTokenizer st = new StringTokenizer(getModules(), ",");
        	while (st.hasMoreTokens()) {
        		String allowedModule = st.nextToken();
        		if (user.getAuthorizedModules().contains(allowedModule)) {
        			print = true;
        			break;
        		}
        	}
        	
            if (print) {
                try {
                    bodyContent.writeOut(getPreviousOut());
                }
                catch (IOException e) {
                	ServiceLocator.getInstance().getLogHelper().error(e);
                }
            }
        }

        //calls doEndTag()
        return this.SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        //calls release()
        return EVAL_PAGE;
    }

	public String getModules() {
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

}
