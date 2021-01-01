package user;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;

import common.clsMovie;
import oracle.jdbc.pool.OracleDataSource;
import oracle.sql.BLOB;

public class DbHandlerUser
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
	
	
	
	public LinkedList<clsMovie> getLinkListMovie ()
	{
		LinkedList<clsMovie> lst =new LinkedList<clsMovie>();
		
		con=getDbCon();
		
		try 
		{
			stmt=con.prepareStatement("select  * from TBLMOVIES");
			rset=stmt.executeQuery();
			
			
//			desc TBLMOVIES
//			Name        Null     Type         
//			----------- -------- ------------ 
//		1	MOVIEID NOT NULL NUMBER(5) 
//		2	MOVIENAME          VARCHAR2(20) 
//		3	STARS           VARCHAR2(5) 
//		4	STARTDATE          DATE    
//		5	ENDDATE          DATE    
//		6	SLOT912          VARCHAR2(10) 
//		7	SLOT1215          VARCHAR2(10) 
//		8	SLOT1518          VARCHAR2(10) 
//		9	SLOT1821          VARCHAR2(10) 
//		10	GOLDPRICE          NUMBER(3) 
//		11	SILVERPRICE          NUMBER(3) 
//		12  IMAGENAME          VARCHAR2(20) 
//		13	LANGUAGE          VARCHAR2(20) 
			while(rset.next())
			{
				int  intMovieId=rset.getInt("MOVIEID")
					,intGoldPrice=rset.getInt("GOLDPRICE")
					,intSilverPrice=rset.getInt("SILVERPRICE");
				
				String   strMovieName=rset.getString("MOVIENAME")
					    ,strMovieStar=rset.getString("STARS")
					    ,strMovieLanguage=rset.getString("LANGUAGE")
						,strSlot912=rset.getString("SLOT912")
						,strSlot1215=rset.getString("SLOT1215")
						,strSlot1518=rset.getString("SLOT1518")
						,strSlot1821=rset.getString("SLOT1821")
					    ,strMovieImageName=rset.getString("IMAGENAME");
				Date strStartDate=rset.getDate("STARTDATE"),
						strEndDate=rset.getDate("ENDDATE");
				
			//	Blob blobMovieImage=rset.getBlob("");
				
				 clsMovie objClsMovie = new clsMovie(intMovieId, intGoldPrice, intSilverPrice, strMovieName, strMovieStar, strMovieLanguage, strSlot912, strSlot1215, strSlot1518, strSlot1821, strStartDate, strEndDate, strMovieImageName);
				
				 lst.add(objClsMovie);
				
				
				
			}//while
				
			 con.close();
		} catch (SQLException e) {e.printStackTrace();}

		return lst;
		
	
		
	}
	
	
	public clsMovie getMovieDetailsByMovieId ( int movieID)
	{
		clsMovie objClsMovie =new clsMovie();
		
		con=getDbCon();
		
		try 
		{
			stmt=con.prepareStatement("select  * from TBLMOVIES where MOVIEID=?");
			stmt.setInt(1, movieID);
			rset=stmt.executeQuery();
			
			
//			desc TBLMOVIES
//			Name        Null     Type         
//			----------- -------- ------------ 
//		1	MOVIEID NOT NULL NUMBER(5) 
//		2	MOVIENAME          VARCHAR2(20) 
//		3	STARS           VARCHAR2(5) 
//		4	STARTDATE          DATE    
//		5	ENDDATE          DATE    
//		6	SLOT912          VARCHAR2(10) 
//		7	SLOT1215          VARCHAR2(10) 
//		8	SLOT1518          VARCHAR2(10) 
//		9	SLOT1821          VARCHAR2(10) 
//		10	GOLDPRICE          NUMBER(3) 
//		11	SILVERPRICE          NUMBER(3) 
//		12  IMAGENAME          VARCHAR2(20) 
//		13	LANGUAGE          VARCHAR2(20) 
			while(rset.next())
			{
				int  intMovieId=rset.getInt("MOVIEID")
					,intGoldPrice=rset.getInt("GOLDPRICE")
					,intSilverPrice=rset.getInt("SILVERPRICE");
				
				String   strMovieName=rset.getString("MOVIENAME")
					    ,strMovieStar=rset.getString("STARS")
					    ,strMovieLanguage=rset.getString("LANGUAGE")
						,strSlot912=rset.getString("SLOT912")
						,strSlot1215=rset.getString("SLOT1215")
						,strSlot1518=rset.getString("SLOT1518")
						,strSlot1821=rset.getString("SLOT1821")
					    ,strMovieImageName=rset.getString("IMAGENAME");
				Date strStartDate=rset.getDate("STARTDATE"),
						strEndDate=rset.getDate("ENDDATE");
				
			//	Blob blobMovieImage=rset.getBlob("");
				
				 objClsMovie = new clsMovie(intMovieId, intGoldPrice, intSilverPrice, strMovieName, strMovieStar, strMovieLanguage, strSlot912, strSlot1215, strSlot1518, strSlot1821, strStartDate, strEndDate, strMovieImageName);
				
			}//while
				
			 con.close();
		} catch (SQLException e) {e.printStackTrace();}

		return objClsMovie;
		
	}
	

}
