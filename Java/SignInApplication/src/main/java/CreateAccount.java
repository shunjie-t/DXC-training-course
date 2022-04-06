import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccount extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = new Model();
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		int rows = 0;
		
		model.setName(name);
		model.setUsername(username);
		model.setPassword(password);
		model.setEmail(email);
		rows = model.createAccount();
		
		if(rows == 0) {
			response.sendRedirect("/SignInApplication/failure.html");
		}
		else {
			response.sendRedirect("/SignInApplication/success.html");
		}
	}
}
