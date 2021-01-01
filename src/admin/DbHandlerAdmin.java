package admin;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import bookmyshow.clsMovie;

import bookmyshow.clsticket;
import oracle.jdbc.pool.OracleDataSource;

public class DbHandlerAdmin 
{
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	
	
	public Connection getDbCon	()
	{
		
		
		
		try 
		{
			OracleDataSource ods= new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("kartik", "icsd");
		
		
		} catch (SQLException e) {e.printStackTrace();}
		
		return con;
	}
	
//	desc tblticket
//	Name              Null     Type          
//	----------------- -------- ------------- 
//	ID                NOT NULL NUMBER(8)     
//	MOVIEID                    NUMBER(8)     
//	TICKETID                   NUMBER(4)     
//	UNM                        VARCHAR2(30)  
//	MOB                        VARCHAR2(30)  
//	EMAILID                    VARCHAR2(30)  
//	GOLDSEATSBOOKED            VARCHAR2(300) 
//	SILVERSEATSBOOKED          VARCHAR2(300) 
//	DATEOFSHOW                 DATE          
//	SLOT                       VARCHAR2(30)  
//	TOTALPRICE                 NUMBER(5) 
	public void insertintotblticket(int ticketid,String strMovieId,String strMid,String strunm,String strMob,String Eid,String strGoldSeatsBooked,
			String strSilverSeatsBooked,String strSlot,Date dtOfShow,double dblTtlPrice)	
	{

		Connection con=getDbCon();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into tblticket values(?,?,?,?,?,?,?,?,?,?,?)");
			
			
			stmt.setInt(1,ticketid);
			stmt.setString(2,strMid);
			stmt.setInt(3,ticketid);
			stmt.setString(4,strunm);
			stmt.setString(5,strMob);
			stmt.setString(6,Eid);
			stmt.setString(7,strGoldSeatsBooked);
			stmt.setString(8,strSilverSeatsBooked);
			stmt.setDate(9,dtOfShow);
			stmt.setString(10,strSlot);
			stmt.setDouble(11,dblTtlPrice);
			
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableticket");

		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	
//	desc tblmovies
//	Name        Null Type         
//	----------- ---- ------------ 
//	MOVIEID          NUMBER(5)    
//	MOVIENAME        VARCHAR2(20) 
//	STARS            VARCHAR2(5)  
//	STARTDATE        DATE         
//	ENDDATE          DATE         
//	SLOT912          VARCHAR2(10) 
//	SLOT1215         VARCHAR2(10) 
//	SLOT1518         VARCHAR2(10) 
//	SLOT1821         VARCHAR2(10) 
//	GOLDPRICE        NUMBER(3)    
//	SILVERPRICE      NUMBER(3)    
//	IMAGENAME        VARCHAR2(20) 
//	LANGUAGE         VARCHAR2(20) 
	public clsMovie getmoviedetailbymovieid(String strmid)
	{
		clsMovie objci=null;
		
		
		Connection con=getDbCon();
		try
		{
			PreparedStatement stmt= con.prepareStatement("select * from tblmovies where movieid=?");
			stmt.setString(1,strmid);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				String strMovieId=rset.getString("movieid"),
						strMovieName=rset.getString("moviename"),
						strStars=rset.getString("stars"),
						strSlot912=rset.getString("SLOT912"),
						strSlot1215=rset.getString("SLOT1215"),
						strSlot1518=rset.getString("SLOT1518"),
						strSlot1821=rset.getString("SLOT1821"),
				strImageName=rset.getString("IMAGENAME"),
				strLanguage=rset.getString("LANGUAGE");
				Date dtStartDate=rset.getDate("STARTDATE"),
				dtEndDate=rset.getDate("ENDDATE");
				double dblGoldPrice=rset.getDouble("GOLDPRICE"),
				dblSilverPrice=rset.getDouble("SILVERPRICE");
				
				objci=new clsMovie(strMovieId, strMovieName, strStars, strSlot912, strSlot1215, strSlot1518, strSlot1821, strImageName, strLanguage, dtStartDate, dtEndDate, dblGoldPrice, dblSilverPrice);
			}
			
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return objci;
		// TODO Auto-generated method stub

	}

	

//	desc tblseatbooked
//	Name             Null Type          
//	---------------- ---- ------------- 
//	ID                    NUMBER(10)    
//	MOVIEID               NUMBER(8)     
//	TTLGOLDSEATS          NUMBER(8)     
//	TTLSILVERSEATS        NUMBER(8)     
//	GOLDSEATBOOKED        VARCHAR2(300) 
//	SILVERSEATBOOKED      VARCHAR2(300) 
//	DATEOFSHOW            DATE          
//	GOLDAVAILSEATS        NUMBER(8)     
//	SILVERAVAILSEATS      NUMBER(8)     
//	SLOTOFSHOW            VARCHAR2(10)
	//GOLDAVAILSEATS,SILVERAVAILSEATS,SLOTOFSHOW
	
	

	public void updatesilverseatsbooked(String strNewSilverSeats, String strmid, String strshowtime,Date dtOfShow)
	{
		Connection con=getDbCon();

		try {
			
			PreparedStatement stmt=con.prepareStatement("update tblseatbooked set SILVERSEATBOOKED=? where movieid=? and slotofshow=? and dateofshow=to_date(?,'dd-MON-yy')");
			System.out.println("ethe hun bauji");
			stmt.setString(1,strNewSilverSeats);
			stmt.setString(2,strmid);
			stmt.setString(3, strshowtime);
			stmt.setDate(4, dtOfShow);
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableseatbooked");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}


	public void updateGoldseatsbooked(String strNewGoldSeats, String strmid, String strshowtime,Date dtOfShow)
	{
		Connection con=getDbCon();

		try {
			
			PreparedStatement stmt=con.prepareStatement("update tblseatbooked set GOLDSEATBOOKED=? where movieid=? and slotofshow=? and dateofshow=to_date(?,'dd-MON-yy')");
			System.out.println("ethe hun bauji");
			stmt.setString(1,strNewGoldSeats);
			stmt.setString(2,strmid);
			stmt.setString(3, strshowtime);
			stmt.setDate(4, dtOfShow);
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableseatbooked");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}


	
	
	
	public LinkedList< ClsTblSeatBooked> lstGetseatsbookedbyidandtimeandDateOfShowSql(String strmid, String strshowtime,Date strDateOfShow)
	{
		LinkedList<ClsTblSeatBooked> lst=new LinkedList<>();
		ClsTblSeatBooked objTblSeatsBooked=null;
		
		
		Connection con=getDbCon();
		try
		{
			//select  * FROM tblseatbooked where movieid=12 and dateofshow='15-apr-2020' and slotofshow=912;
			PreparedStatement stmt= con.prepareStatement("select  * FROM tblseatbooked where movieid=? and dateofshow=? and slotofshow=?");
			stmt.setString(1,strmid);
			stmt.setString(2,strshowtime);
			stmt.setDate(3, strDateOfShow);

	
			
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			while(rset.next())
			{
				int id=rset.getInt("id"),movieid=rset.getInt("movieid"),ttlGoldSeats=rset.getInt("TTLGOLDSEATS"),
						ttlSilverSeats=rset.getInt("TTLSILVERSEATS"),goldAvailseats=rset.getInt("GOLDAVAILSEATS"),
				silverAvailSeats=rset.getInt("SILVERAVAILSEATS");
				String strSlotOfShow=rset.getString("SLOTOFSHOW"),strGoldSeatsBooked=rset.getString("GOLDSEATBOOKED"),
						strSilverSeatsBooked=rset.getString("SILVERSEATBOOKED");
				Date dateOfShow=rset.getDate("dateofshow");
				
				objTblSeatsBooked=new ClsTblSeatBooked(id, movieid, ttlGoldSeats, ttlSilverSeats, goldAvailseats, silverAvailSeats, strSlotOfShow, strGoldSeatsBooked, strSilverSeatsBooked, dateOfShow);
			System.out.println("inside getseatsbookedbyidandtimeandDateOfShowSql "+objTblSeatsBooked);
				lst.add(objTblSeatsBooked);
			}
			
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return lst;


		
	}
	
	
	
	public LinkedList<String> lstGetUniqueDateseatsbookedbyid(String strmid)
	{
		LinkedList<String> lst=new LinkedList<>();
		ClsTblSeatBooked objTblSeatsBooked=null;
		
		
		Connection con=getDbCon();
		try
		{
			//select  * FROM tblseatbooked where movieid=12 and dateofshow='15-apr-2020' and slotofshow=912;
			PreparedStatement stmt= con.prepareStatement("select  DISTINCT to_char(dateofshow,'dd-MON-yyyy') AS DATEOFSHOW FROM tblseatbooked where movieid=?");
			stmt.setString(1,strmid);
	
			
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			while(rset.next())
			{
				
				System.out.println("1.1");			
				//Date dateOfShow=rset.getDate("DATEOFSHOW");
				 String dateOfShow=rset.getString("DATEOFSHOW");
				 
				System.out.println("1.2");
				
				System.out.println("lstGetUniqueDateseatsbookedbyid "+dateOfShow+" ");
				lst.add(dateOfShow);
			}
			
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return lst;


		
	}
	public ClsTblSeatBooked getseatsbookedbyidandtimeandDateOfShowSql(String strmid, String strshowtime,Date sqlDateOfShow)
	{
		ClsTblSeatBooked objTblSeatsBooked=null;
		
		
		Connection con=getDbCon();
		try
		{
			//select  * FROM tblseatbooked where movieid=12 and dateofshow='15-apr-2020' and slotofshow=912;
//			PreparedStatement stmt= con.prepareStatement("select  ID,MOVIEID,TTLGOLDSEATS,TTLSILVERSEATS,GOLDSEATBOOKED,SILVERSEATBOOKED,to_char(dateofshow,'dd-MON-yyyy') AS DATEOFSHOW,GOLDAVAILSEATS,SILVERAVAILSEATS,SLOTOFSHOW FROM tblseatbooked where movieid=? and dateofshow=? and slotofshow=?");
			//PreparedStatement stmt=con.prepareStatement("select to_date('"+strStartDate+"')- to_date('"+strEndDate+"') as diff from dual");
			PreparedStatement stmt= con.prepareStatement("select  * FROM tblseatbooked where movieid=? and dateofshow=to_date(?,'dd-MON-yy') and slotofshow=?");
			//											  select  * FROM tblseatbooked where movieid=12 and dateofshow=to_date('17-Apr-2020','dd-MON-yy') and slotofshow=912;
			stmt.setString(1,strmid);
			stmt.setString(3,strshowtime);
		     SimpleDateFormat dfDateFormat = new SimpleDateFormat("dd-MMM-yy");

		    

		        
		        System.out.println("inside getsetatsbookedbyidanditineanddateofshow = formatted  "+dfDateFormat.format(sqlDateOfShow));
		        String strDateOfShow=dfDateFormat.format(sqlDateOfShow);
		        //                  inside getsetatsbookedbyidanditineanddateofshow = formatted  17-Apr-20
		    
			//stmt.setDate(3, sqlDateOfShow);
		        System.out.println("strDateofshow "+ strDateOfShow);
		        stmt.setString(2,strDateOfShow);
			////////////////////////strDateofShow inside getseatsbookedbyidandtimeanddateofshowsql 2020-04-17                                                             2020-04-17
			System.out.println("strDateofShow inside getseatsbookedbyidandtimeanddateofshowsql "+sqlDateOfShow);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				int id=rset.getInt("id"),movieid=rset.getInt("movieid"),ttlGoldSeats=rset.getInt("TTLGOLDSEATS"),
						ttlSilverSeats=rset.getInt("TTLSILVERSEATS"),goldAvailseats=rset.getInt("GOLDAVAILSEATS"),
				silverAvailSeats=rset.getInt("SILVERAVAILSEATS");
				String strSlotOfShow=rset.getString("SLOTOFSHOW"),strGoldSeatsBooked=rset.getString("GOLDSEATBOOKED"),
						strSilverSeatsBooked=rset.getString("SILVERSEATBOOKED");
				Date dateOfShow=rset.getDate("dateofshow");
			
				
				objTblSeatsBooked=new ClsTblSeatBooked(id, movieid, ttlGoldSeats, ttlSilverSeats, goldAvailseats, silverAvailSeats, strSlotOfShow, strGoldSeatsBooked, strSilverSeatsBooked, dateOfShow);
			System.out.println("inside getseatsbookedbyidandtimeandDateOfShowSql "+objTblSeatsBooked);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"no record found");
			}
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return objTblSeatsBooked;
		// TODO Auto-generated method stub

		
	}
	public int getMaxId(String strTblNm,String strcolnM)
	{
		int maxId=0;
		Connection con=getDbCon();
		
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+strcolnM+")as id from "+strTblNm);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				maxId=rset.getInt("id");
			}
			else
			{
				maxId=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  maxId+=1;
		return maxId;
	}

//	desc tblseatbooked
//	Name             Null Type          
//	---------------- ---- ------------- 
//	ID                    NUMBER(10)    
//	MOVIEID               NUMBER(8)     
//	TTLGOLDSEATS          NUMBER(8)     
//	TTLSILVERSEATS        NUMBER(8)     
//	GOLDSEATBOOKED        VARCHAR2(300) 
//	SILVERSEATBOOKED      VARCHAR2(300) 
//	DATEOFSHOW            VARCHAR2(50)  
//	GOLDAVAILSEATS        NUMBER(8)     
//	SILVERAVAILSEATS      NUMBER(8)     
//	SLOTOFSHOW            VARCHAR2(10)  
	public void insertintotblseatbooked( String strmid, String totalgseats,
			String totalsseats, String strgoldseatbooked, String strsilverseatbooked, String strdateofshow,
			String strgoldseatsremaining, String strsilverseatsavailable, String strslotofshow)
	{

		Connection con=getDbCon();

		try {
			Date StartDate= Date.valueOf(strdateofshow);
					;
			PreparedStatement stmt=con.prepareStatement("insert into tblseatbooked values(?,?,?,?,?,?,?,?,?,?)");
			String strId=String.valueOf(getMaxId("tblseatbooked", "ID"));
			stmt.setString(1,strId);
			stmt.setString(2,strmid);
			stmt.setString(3,totalgseats);
			stmt.setString(4,totalsseats);
			stmt.setString(5,strgoldseatbooked);
			stmt.setString(6,strsilverseatbooked);
			stmt.setDate(7,StartDate);
			stmt.setString(8,strgoldseatsremaining);
			stmt.setString(9,strsilverseatsavailable);
			stmt.setString(10,strslotofshow);
		
			
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableseatbooked");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
	}
	
	public void uploadMovie(int  intMovieId,String strMovieName,String strMovieStar
								,String  strStartDate,String  strEndDate
								,String strSlot912,String strSlot1215,String strSlot1518,String strSlot1821
								,int intGoldPrice,int intSilverPrice,
								/////// image paerameter.............. 
								String strMovieLanguage,String strMovieImageName)
	{
		
		
			Date StartDate= Date.valueOf(strStartDate),
				 EndDate=Date.valueOf(strEndDate);
			System.out.println(StartDate);
			System.out.println(EndDate);
		
//		desc TBLMOVIES
//		Name        Null     Type         
//		----------- -------- ------------ 
//	1	MOVIEID NOT NULL NUMBER(5) 
//	2	MOVIENAME          VARCHAR2(20) 
//	3	STARS           VARCHAR2(5) 
//	4	STARTDATE          DATE    
//	5	ENDDATE          DATE    
//	6	SLOT912          VARCHAR2(10) 
//	7	SLOT1215          VARCHAR2(10) 
//	8	SLOT1518          VARCHAR2(10) 
//	9	SLOT1821          VARCHAR2(10) 
//	10	GOLDPRICE          NUMBER(3) 
//	11	SILVERPRICE          NUMBER(3) 
//	12  IMAGENAME          VARCHAR2(20) 
//	13	LANGUAGE          VARCHAR2(20) 

		con=getDbCon();
		try 
		{
			//......................................................1  2   3   4   5   6   7   8   9  10  11  12   13
			stmt=con.prepareStatement("insert into TBLMOVIES values(?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)");
			
			stmt.setInt(1, intMovieId);
			stmt.setString(2, strMovieName);
			stmt.setString(3, strMovieStar);
		    stmt.setDate(4,StartDate);
			stmt.setDate(5,EndDate);
			stmt.setString(6,strSlot912);
			stmt.setString(7,strSlot1215);
			stmt.setString(8,strSlot1518);
			stmt.setString(9,strSlot1821);
			stmt.setInt(10,intGoldPrice);
			stmt.setInt(11,intSilverPrice);
			stmt.setString(12,strMovieImageName);
			stmt.setString(13, strMovieLanguage);
			
			stmt.executeUpdate();
			con.close();
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
	}
	
	
	
	
	
	
	
	
}
