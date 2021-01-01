package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ICSDAuthSupport 
{
	public static HttpSession CheckAuthenticity(HttpServletRequest request)throws ICSDAuthException
	{
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			// invalid user
			throw new ICSDAuthException("PLEASE LOGIN FIRST !!!!!!!!");
		}
		//valid user
		return session;
				
	}

	
}

