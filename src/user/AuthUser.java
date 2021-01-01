package user;

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

import admin.DbHandlerAdmin;


@WebServlet("/AuthUser")
public class AuthUser extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
   
    public AuthUser() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String  strUserUnm =request.getParameter("uUnm")
				,strUserPwd=request.getParameter("uPwd");
	
		DbHandlerUser objDbA = new DbHandlerUser();
		con= objDbA.getDbCon();
		
		
//		desc USERLOGIN
//		Name   Null Type         
//		------ ---- ------------ 
//		USERID      NUMBER(10) 
//		UNM      VARCHAR2(20) 
//		UPWD      VARCHAR2(30) 
		try
		{ 
			System.out.println("con made");
			stmt=con.prepareStatement("select * from USERLOGIN where UNM =? and UPWD =?");
			
			stmt.setString(1, strUserUnm);
			stmt.setString(2, strUserPwd);
			
			rset=stmt.executeQuery();
			
			if(rset.next())
			{
				
				int intUserId=rset.getInt("USERID");
				HttpSession session =request.getSession();//new session created
				session.setAttribute("aid", intUserId);
				response.sendRedirect(request.getContextPath()+"/WelcomePageUser.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/ErrorPageUser.jsp");
			}
		
		
		
		} catch (SQLException e) {e.printStackTrace();}
	
	}

}
