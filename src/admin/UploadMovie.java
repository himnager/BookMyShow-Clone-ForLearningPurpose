package admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UploadMovie")
public class UploadMovie extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
   
    public UploadMovie() 
    {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		DbHandlerAdmin objDH=new DbHandlerAdmin();
			int  intMovieId=  objDH.getMaxId("TBLMOVIES", "MOVIEID"),
				intGoldPrice= Integer.parseInt(request.getParameter("gPrice")),
				intSilverPrice= Integer.parseInt(request.getParameter("sPrice"));
			
			
			String strMovieName=request.getParameter("mNm")
					,strMovieStar=request.getParameter("mStar")
					,strMovieLanguage=request.getParameter("mLang")
					,strSlot912=request.getParameter("slot912")	
					,strSlot1215=request.getParameter("slot1215")
					,strSlot1518=request.getParameter("slot1518")
					,strSlot1821=request.getParameter("slot1821")
					,strStartDate=request.getParameter("sDate")
					,strEndDate=request.getParameter("eDate")
					,strMovieImageName=request.getParameter("mInm");

					
					
					
			System.out.println(intMovieId);
			System.out.println(strMovieName);
			System.out.println(strMovieStar);
			System.out.println(strStartDate );
			System.out.println(strEndDate);
			System.out.println(strSlot912);
			System.out.println(strSlot1215);
			System.out.println(strSlot1518);
			System.out.println(strSlot1821);
			System.out.println(intGoldPrice);
			System.out.println(intSilverPrice);
			System.out.println(strMovieImageName);
			System.out.println(strMovieLanguage);

			
			
			DbHandlerAdmin objDbA = new DbHandlerAdmin();
			
			objDbA.uploadMovie(intMovieId, strMovieName, strMovieStar, strStartDate, strEndDate, strSlot912, strSlot1215, strSlot1518, strSlot1821, intGoldPrice, intSilverPrice, strMovieLanguage,strMovieImageName);
			

			
			objDbA.insertintotblseatbooked(String.valueOf(intMovieId), "30", "20", "", "", strStartDate, "30","20", "912");
			
		    response.sendRedirect(request.getContextPath()+"/success.jsp?what=MOVIE%20UPLOADED");
		

			
	}

}
