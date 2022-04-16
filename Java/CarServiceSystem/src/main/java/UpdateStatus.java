import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cun = request.getParameter("cun");		
		
		Model m = new Model();
		m.setCun(cun);
		int row = m.UpdateStatus();
		System.out.println(row);
		
		if(row == 1) {
			response.sendRedirect("/CarServiceSystem/updateStatusSuccess.html");
		}
		else {
			response.sendRedirect("/CarServiceSystem/updateStatusFailure.html");
		}
	}
}
