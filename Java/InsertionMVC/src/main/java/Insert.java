import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int marks1 = Integer.parseInt(request.getParameter("marks1"));
		int marks2 = Integer.parseInt(request.getParameter("marks2"));
		int marks3 = Integer.parseInt(request.getParameter("marks3"));
		
		Model m = new Model();
		m.setId(id);
		m.setName(name);
		m.setMarks1(marks1);
		m.setMarks2(marks2);
		m.setMarks3(marks3);
		
		int rows = m.insert();
		if(rows == 0 ) {
			response.sendRedirect("/InsertionMVC/failure.html");
		}
		else {
			response.sendRedirect("/InsertionMVC/success.html");
		}
	}
}
