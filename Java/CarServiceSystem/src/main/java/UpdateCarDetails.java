import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateCarDetails extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carmodel = request.getParameter("carmodel");
		String cartype = request.getParameter("cartype");
		String carregnumber = request.getParameter("carregnumber");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("cun");
		
		Model m = new Model();
		m.setCun(username);
		m.setCarmodel(carmodel);
		m.setCartype(cartype);
		m.setCarregnumber(carregnumber);
		m.setServicerequest("");
		m.setStatus("");
		
		int rows = m.updateCarDetails();
		
		if(rows == 0) {
			response.sendRedirect("/CarServiceSystem/updateCarDetailsFailure.html");
		}
		else {
			response.sendRedirect("/CarServiceSystem/updateCarDetailsSuccess.jsp");
		}
	}
}
