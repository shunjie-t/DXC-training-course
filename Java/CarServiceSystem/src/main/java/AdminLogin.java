import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aun = request.getParameter("aun");
		String apwd = request.getParameter("apwd");
		
		Model m = new Model();
		m.setAun(aun);
		m.setApwd(apwd);
		
		int x = m.adminVerify();
		if(x == 0) {
			response.sendRedirect("/CarServiceSystem/adminLoginFailure.html");
		}
		else {
			response.sendRedirect("/CarServiceSystem/adminLoginSuccess.jsp");
		}
	}
}
