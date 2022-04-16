import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisteredCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model m = new Model();
		ArrayList<Customer> al = m.getRegisteredCustomers();
		PrintWriter pw = response.getWriter();
		
		for(int i = 0; i < al.size(); i++) {
			pw.println(al.get(i));
		}
		
		response.sendRedirect("/CarServiceSystem/registeredCustomerSuccess.jsp");
	}
}
