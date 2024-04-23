import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
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
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		EmployeeDao.delete(id); 
		resp.sendRedirect("ViewServlet");
	}

}
