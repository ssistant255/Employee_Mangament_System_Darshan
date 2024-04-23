import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.setContentType("text/html");
		  resp.getWriter().println("<!DOCTYPE html>");
	      resp.getWriter().println("<html>");
	      resp.getWriter().println("<head>");
	      resp.getWriter().println("<title>Background Image</title>");
	      resp.getWriter().println("<style>");
	      resp.getWriter().println("body {");
	      resp.getWriter().println("     background-image: url('https://wallpaperaccess.com/full/4322200.jpg');");
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
	  	    PrintWriter out=resp.getWriter();
	  	    out.println("<a href='index.html'>Add New Employee</a>");
	  	    out.println("<h1>Employees List</h1>");
	  	    List<Employee> list=EmployeeDao.getAllEmployees();
	  	    out.println("<table border='1' width='100%'");
	  	    out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Contact</th><th>Edit</th><th>Delete</th></tr>"); 
	  	    for(Employee e:list)
	  	    {
	  	    	out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmailid()+"</td><td>"+e.getPassword()+"</td><td>"+e.getContact()+"</td><td>"+ "<a href='EditServlet?id="+e.getId()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>"); 
	  	    	
	  	    }
	  	    out.println("</table>");
	  	    out.close();
	  	}
}