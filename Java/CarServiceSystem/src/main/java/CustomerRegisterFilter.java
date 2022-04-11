

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CustomerRegisterFilter
 */
public class CustomerRegisterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CustomerRegisterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String cpwd = request.getParameter("cpwd");
		String ccpwd = request.getParameter("ccpwd");
		
		if(cpwd.equals(ccpwd)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("/CarServiceSystem/errorRegister.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
