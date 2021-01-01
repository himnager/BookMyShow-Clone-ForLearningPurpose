package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.ClsTblSeatBooked;
import admin.DbHandlerAdmin;
import bookmyshow.clsMovie;

@WebServlet("/BookSeat")
public class BookSeat extends HttpServlet {
	
    public BookSeat() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out=response.getWriter();
		DbHandlerAdmin objDHA=new DbHandlerAdmin();
		String SilverSeatCheckBox[]=request.getParameterValues("SilverSeatCheckBox")  ;
		String GoldSeatCheckBox[]=request.getParameterValues("GoldSeatCheckBox")  ;
	   //  String strMid="12";
		HttpSession session=request.getSession(false);
		 String strMid= session.getAttribute("ssnmid").toString();
	     int mid=Integer.parseInt(strMid);
		/////String strSlotChoosen="1518",strDateOfShow="17-APR-2020";
	     String strSlotChoosen=request.getParameter("selectedSlot"),strDateOfShow=request.getParameter("selctedDate");
		   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
	       java.util.Date date = null;
		try {
			date = sdf1.parse(strDateOfShow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       java.sql.Date dt = new java.sql.Date(date.getTime());
	     
	       String strNewSilverSeatsBooked="";
	       int cnt=SilverSeatCheckBox.length;
	       double dblTtlSilverSeatsPrice=0.0,dblTtlGoldSeatsPrice=0.0;
	       clsMovie  objClsMovie=objDHA.getmoviedetailbymovieid(strMid);
	       double dblSilverSeatPrice=objClsMovie.getDblSilverPrice();
	       double dblGoldSeatPrice=objClsMovie.getDblGoldPrice();
	       
		for (String strSilverSeatBooked : SilverSeatCheckBox)			
		{
			if((SilverSeatCheckBox.length-1)==cnt)
			{
				strNewSilverSeatsBooked=strNewSilverSeatsBooked+strSilverSeatBooked;	
			}
			else
			{
				strNewSilverSeatsBooked=strNewSilverSeatsBooked+strSilverSeatBooked+",";
			}
			cnt++;
			dblTtlSilverSeatsPrice=dblTtlSilverSeatsPrice+dblSilverSeatPrice;
			out.println("SilverSeatBooked "+ strSilverSeatBooked);
		}
		out.println("new seats silver seats booked = "+strNewSilverSeatsBooked);
		
		
		
		ClsTblSeatBooked  objClsTblSeatBooked= objDHA.getseatsbookedbyidandtimeandDateOfShowSql(strMid,strSlotChoosen,dt);
		
		
		String strOldSilverSeatsBooked=objClsTblSeatBooked.getStrSilverSeatsBooked();
		
		String strLatestSilverSeatsBooked=strOldSilverSeatsBooked+strNewSilverSeatsBooked;
		objDHA.updatesilverseatsbooked(strLatestSilverSeatsBooked, strMid, strSlotChoosen, dt);
		
		
		
		//========================================================================================
		
		   String strNewGoldSeatsBooked="";
	       int cntG=GoldSeatCheckBox.length;
		for (String strGoldSeatBooked : GoldSeatCheckBox)			
		{
			if((GoldSeatCheckBox.length-1)==cntG)
			{
				strNewGoldSeatsBooked=strNewGoldSeatsBooked+strGoldSeatBooked;	
			}
			else
			{
				strNewGoldSeatsBooked=strNewGoldSeatsBooked+strGoldSeatBooked+",";
			}
			cnt++;
			dblTtlGoldSeatsPrice=dblTtlGoldSeatsPrice+dblGoldSeatPrice;
			out.println("SilverSeatBooked "+ strGoldSeatBooked);
		}
		out.println("new seats Gold seats booked = "+strNewGoldSeatsBooked);
		
		
		
		
		
		String strOldGoldSeatsBooked=objClsTblSeatBooked.getStrGoldSeatsBooked();
		
		String strLatestGoldSeatsBooked=strOldGoldSeatsBooked+strNewGoldSeatsBooked;
		objDHA.updateGoldseatsbooked(strLatestGoldSeatsBooked, strMid, strSlotChoosen, dt);
		
		
		
		
		//========================Ticket generation============================
//		desc tblticket
//		Name              Null     Type          
//		----------------- -------- ------------- 
//		ID                NOT NULL NUMBER(8)     
//		MOVIEID                    NUMBER(8)     
//		TICKETID                   NUMBER(4)     
//		UNM                        VARCHAR2(30)  
//		MOB                        VARCHAR2(30)  
//		EMAILID                    VARCHAR2(30)  
//		GOLDSEATSBOOKED            VARCHAR2(300) 
//		SILVERSEATSBOOKED          VARCHAR2(300) 
//		DATEOFSHOW                 DATE          
//		SLOT                       VARCHAR2(30)  
//		TOTALPRICE                 NUMBER(5)   
		
		String strUNM="deepak",strMob="123456",strEid="d@d.com",strGoldSeatsBooked=strNewGoldSeatsBooked,
				strSilverSeatsBooked=strNewSilverSeatsBooked,strSlot=strSlotChoosen;
		Date dtOfShow=dt;
		double dblTtlPrice=dblTtlGoldSeatsPrice+dblTtlSilverSeatsPrice;
		int intTicketId=objDHA.getMaxId("tblTicket", "id");
		objDHA.insertintotblticket(intTicketId, strMid, strMid, strUNM, strMob, strEid, strGoldSeatsBooked, strSilverSeatsBooked, strSlot, dtOfShow, dblTtlPrice);
		
		out.println("ticekt generated is "+ intTicketId);
		response.sendRedirect(request.getContextPath()+"/WelcomePageUser.jsp");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
