package icsd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
    
	Connection con;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	String strUnm=null,strPwd=null,strDBUrl=null;
	
	
	
	public Auth() {
    }
    
    public Connection getDBCon()
    {
    	try {
			OracleDataSource ods=new OracleDataSource();
			ods.setURL(strDBUrl);
			con=ods.getConnection(strUnm,strPwd);
			System.out.println("connection established successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return con;
    	
    }
    public void init(ServletConfig config) throws ServletException
    {
    
    	strDBUrl="jdbc:oracle:thin:@localhost:1521:xe";
    	strUnm="kartik";
    	strPwd="icsd";
    	
    	
    	System.out.println("at  Auth ContextParameters   from web.xml "+strDBUrl+" "+ strUnm+" "+ strPwd);
    	con=getDBCon();
    	try {
			stmt=con.prepareStatement("select * from tbluser where unm=? and pwd=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void destroy()
    {
    	try
    	{
	    	if(con!=null)
	    	{
	    		con.close();
	    	}
	    	if(stmt!=null)
	    	{
	    		stmt.close();
	    	}
	    	if(rset!=null)
	    	{
	    		rset.close();
	    	}
    	}
    	catch(SQLException se)
    	{
    		System.out.println(se.getMessage());
    	}
    } 
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String strUnm,strPwd;
			strUnm=request.getParameter("txtUnm");
			strPwd=request.getParameter("txtPwd");
			
			try {
				stmt.setString(1, strUnm);
				stmt.setString(2, strPwd);
				rset=stmt.executeQuery();
				if(rset.next())
				{
					//url rewriting - data is being sent here using url 
					//url rewriting - query string - you can send only string  -binary data we can not send 
					//this method is not secure - coz data we send will be visible inside url - so we should not
					//send sensitive data with the help of url rewriting.
					response.sendRedirect(request.getContextPath()+"/WelcomePage?unm="+strUnm+"&age=20&citynm=delhi");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/ErrorPage");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
