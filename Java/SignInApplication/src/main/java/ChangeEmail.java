import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeEmail
 */
public class ChangeEmail extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("newEmail");
		HttpSession session = request.getSession();
		String un = (String) session.getAttribute("username");
		Model m = new Model();
		m.setEmail(email);
		m.setUsername(un);
		
		int res = m.updateEmail();
		
		if(res == 0) {
			response.sendRedirect("/SignInApplication/emailUpdateFailure.html");
		}
		else {
			response.sendRedirect("/SignInApplication/emailUpdateSuccess.html");
		}
	}
}
