import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SignInFilter
 */
public class SignInFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SignInFilter() {
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
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		
		if(un.length() == 0) {
			((HttpServletResponse) response).sendRedirect("/SignInApplication/unEmpty.html");
		}
		else if(pw.length() == 0) {
			((HttpServletResponse) response).sendRedirect("/SignInApplication/pwEmpty.html");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
