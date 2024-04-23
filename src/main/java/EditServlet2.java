import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String contact=req.getParameter("contact");
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmailid(email);
		e.setPassword(password);
		e.setContact(contact);
		int status=EmployeeDao.update(e);
		if(status>0)
		{
			resp.sendRedirect("ViewServlet");
		}
		else
		{
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}