import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao 
{
	public static Connection getConnection()
	{
        Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mini_project","root","darshan3009");
		
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	public static int save(Employee e)
	{
		
		int status = 0;
		
		Connection con =  EmployeeDao.getConnection();
		
		try 
		{
			PreparedStatement ps =  con.prepareStatement("insert into user(name,email_id,password,contact)values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmailid());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getContact());
			
			status = ps.executeUpdate();
			
			con.close();
			
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return status;		
	}
public static int update(Employee e)
{
	
	int status = 0;
	
	Connection con = EmployeeDao.getConnection();
	
	try {
		PreparedStatement ps = con.prepareStatement("Update user set name = ?, email_id =?, password = ?, contact = ? where id = ?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmailid());
		ps.setString(3, e.getPassword());
		ps.setString(4, e.getContact());
		ps.setInt(5, e.getId());
		
		status = ps.executeUpdate();
		
		con.close();
		
	} catch (SQLException e1) 
	{
		e1.printStackTrace();
	}
	return status;
  }
public static int delete(int id)
{
	int status = 0;
	
	Connection con = EmployeeDao.getConnection();
	try 
	{
		PreparedStatement ps = con.prepareStatement("Delete from user where id = ?");
		
		ps.setInt(1, id);
		
		status = ps.executeUpdate();
		
		con.close();
		
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return status;
	
  }
public static Employee getEmployeeById(int id)
{
	
	Employee e =  new Employee();
	
	Connection con = EmployeeDao.getConnection();
	try 
	{
		PreparedStatement ps =  con.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmailid(rs.getString(4));
			e.setContact(rs.getString(5));
			
		}
		con.close();
	} catch (SQLException e1) 
	{
		e1.printStackTrace();
	}
	return e;
   }
public static List<Employee> getAllEmployees()
{
	List<Employee> list = new ArrayList<Employee>();
	
	Connection con =  EmployeeDao.getConnection();
	
	try {
		PreparedStatement ps = con.prepareStatement("Select * from user");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Employee e =  new Employee();
			
			e.setId(rs.getInt(1));
			
			e.setName(rs.getString(2));
			
			e.setEmailid(rs.getString(3));
			
			e.setPassword(rs.getString(4));
			
			e.setContact(rs.getString(5));
			
			list.add(e);
		}
		con.close();
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return list;
  }
}