import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servicerequest = request.getParameter("servicerequest");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("cun");
		
		Model m = new Model();
		m.setCun(username);
		m.setServicerequest(servicerequest);
		m.setStatus("false");
		
		int row = m.updateCarService();
		
		if(row == 1) {
			response.sendRedirect("/CarServiceSystem/serviceRequestSuccess.jsp");
		}
		else {
			response.sendRedirect("/CarServiceSystem/serviceRequestFailure.html");
		}
	}
}
