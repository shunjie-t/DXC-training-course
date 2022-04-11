import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignIn extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		Model m = new Model();
		
		m.setUsername(un);
		m.setPassword(pw);
		
		int res = m.verify();
		
		if(res == -1) {
			response.sendRedirect("/SignInApplication/invalidUsername.html");
		}
		else if(res == 0) {
			response.sendRedirect("/SignInApplication/invalidPassword.html");
		}
		else {
			String name = m.getName();
			String email = m.getEmail();
			HttpSession session = request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("username", un);
			session.setAttribute("email", email);
			response.sendRedirect("/SignInApplication/SignInSuccess.jsp");
		}
	}
}
