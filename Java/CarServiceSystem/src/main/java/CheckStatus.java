import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cun = (String) session.getAttribute("cun");
		
		Model m = new Model();
		m.setCun(cun);
		int row = m.checkUpdate();
		String status = m.getStatus();
		
		session.setAttribute("status", status);
		
		if(row == 1) {
			response.sendRedirect("/CarServiceSystem/CheckStatusSuccess.jsp");
		}
		else {
			response.sendRedirect("/CarServiceSystem/CheckStatusFailure.html");
		}
	}
}
