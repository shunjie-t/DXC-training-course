import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerRegister extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("cname");
		String cun = request.getParameter("cun");
		String cpwd = request.getParameter("cpwd");
		String cemail = request.getParameter("cemail");
		
		Model m = new Model();
		m.setCname(cname);
		m.setCun(cun);
		m.setCpwd(cpwd);
		m.setCemail(cemail);
		
		int rows = m.addCustomerDetails();
		if(rows == 0) {
			response.sendRedirect("/CarServiceSystem/customerRegisterFaliure.html");
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("cname",cname);
			response.sendRedirect("/CarServiceSystem/customerRegisterSuccess.jsp");
		}
	}
}
