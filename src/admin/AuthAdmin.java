package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.security.Init;


@WebServlet("/AuthAdmin")
public class AuthAdmin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
    public AuthAdmin() 
    {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String  strAdminUnm =request.getParameter("aUnm")
				,strAdminPwd=request.getParameter("aPwd");
		
		DbHandlerAdmin objDbA = new DbHandlerAdmin();
		con= objDbA.getDbCon();
		
		try
		{ 
			System.out.println("con made");
			stmt=con.prepareStatement("select * from admin where ANM=? and APWD=?");
			
			stmt.setString(1, strAdminUnm);
			stmt.setString(2, strAdminPwd);
			
			rset=stmt.executeQuery();
			
			if(rset.next())
			{
				
				int intAdminId=rset.getInt("ID");
				con.close();
				HttpSession session =request.getSession();//new session created
				session.setAttribute("aid", intAdminId);
				response.sendRedirect(request.getContextPath()+"/WelcomePageAdmin.jsp");
				
				
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/ErrorPageAdmin.jsp");
			}
	
		} catch (SQLException e) {e.printStackTrace();}
		
	}

}
