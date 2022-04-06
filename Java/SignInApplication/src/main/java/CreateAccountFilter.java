import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CreateAccountFilter
 */
public class CreateAccountFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CreateAccountFilter() {
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
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		
		if(name.length() == 0 || username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0 || email.length() == 0) {
			((HttpServletResponse) response).sendRedirect("/SignInApplication/dataIncompleteError.html");
		}
		else if(!password.equals(confirmPassword)) {
			((HttpServletResponse) response).sendRedirect("/SignInApplication/pwdCpwdNotMatchingError.html");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
