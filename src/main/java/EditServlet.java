import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet  extends HttpServlet  
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
        resp.getWriter().println("      background-image: url('https://wallpaperaccess.com/full/4322200.jpg');");
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
		out.println("<h2>Update Employee</h2>");

		int  id = Integer.parseInt(req.getParameter("id"));
		
		Employee e = EmployeeDao.getEmployeeById(id);
		out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmailid()+"'/></td></tr>");  

        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>"); 
        out.print("<tr><td>Contact:</td><td><input type='contact' name='contact' value='"+e.getContact()+"'/></td></tr>"); 
      
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>"); 
        out.print("</form>");   
          
        out.close();  	
	  }	
}