import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cun = request.getParameter("cun");
		String cpwd = request.getParameter("cpwd");
		
		Model m = new Model();
		m.setCun(cun);
		m.setCpwd(cpwd);
		
		int x = m.customerVerify();
		if(x == 1) {
			String cname = m.getCname();
			HttpSession session = request.getSession();
			session.setAttribute("cname", cname);
			session.setAttribute("cun", cun);
			response.sendRedirect("/CarServiceSystem/customerLoginSuccess.jsp");
		}
		else if(x == -1) {
			response.sendRedirect("/CarServiceSystem/invalidCustomerUsername.html");
		}
		else {
			response.sendRedirect("/CarServiceSystem/invalidCustomerPassword.html");
		}
	}
}
