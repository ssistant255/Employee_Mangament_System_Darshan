import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet
{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	resp.getWriter().println("<!DOCTYPE html>");
    resp.getWriter().println("<html>");
    resp.getWriter().println("<head>");
    resp.getWriter().println("<title>Background Image</title>");
    resp.getWriter().println("<style>");
    resp.getWriter().println("body {");
    resp.getWriter().println("    background-image: url('https://wallpaperaccess.com/full/4322200.jpg');");
    resp.getWriter().println("    background-size: cover;");
    resp.getWriter().println("}");
    resp.getWriter().println("form {");
    resp.getWriter().println("background-color: green");
    resp.getWriter().println("text-align: center;");
    resp.getWriter().println("}");
    resp.getWriter().println("</style>");
    resp.getWriter().println("</head>");
    resp.getWriter().println("<body>");
    resp.getWriter().println("</body>");
    resp.getWriter().println("</html>");
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String password =  req.getParameter("password");
	String contact = req.getParameter("contact");
	PrintWriter out=resp.getWriter();
	Employee e=new Employee();
	e.setName(name);
	e.setEmailid(email);
	e.setPassword(password);
	e.setContact(contact);
	int status=EmployeeDao.save(e);
	if(status>0)
	{
		out.println("<h2>Record Saved...</h2>");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	else
	{
		out.println("<h3>Something went Wrong...</h3>");
	}
   }
}