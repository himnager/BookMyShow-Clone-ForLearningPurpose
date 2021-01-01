package common;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

//import bookmyshow.clsmov;
import bookmyshow.clsticket;
import bookmyshow.clsuser;
import oracle.jdbc.pool.OracleDataSource;
public class TempDBH {
	String  strgoldseatbooked;
	public Connection getdbconwithoracle()
	{
		Connection con=null;

		try {
			
			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("kartik","icsd");

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection established");
		return con;
	}

	public boolean isValidUser(String aunm, String apwd)
	{

		boolean res=false;
		Connection con=getdbconwithoracle();
	// stmt;

		
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("select * from admin where anm=? and apwd=? ");
				stmt.setString(1,aunm);
				stmt.setString(2,apwd);
				
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				if(rset.next())
				{
					res=true;
				}
				else
				{
					res=false;
					
				}
			
			
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
			

		}

	public int getMaxId(String strTblNm,String strcolnM)
	{
		int maxId=0;
		Connection con=getdbconwithoracle();
		
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+strcolnM+")as id from Tblmovies");
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
		  
		return maxId+1;
	}

	public String getMaxmovieidFromtblmovies()
	{	
		String strmaxId="0";
		int id=getMaxId("tblmovies","movieid");
		strmaxId=String.valueOf(id);
		return strmaxId;
		
		
	}

	public void InsertIntoTblmovies(String strmid, String strname, String strstar,
			String strsdate, String stredate, String str912, String str1215,
			String str1518, String str1821, String strgprice, String strsprice, String striname) 
	{
	Connection con=getdbconwithoracle();

	try {
		PreparedStatement stmt=con.prepareStatement("insert into tblmovies values(?,?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1,strmid);
		stmt.setString(2,strname);
		stmt.setString(3,strstar);
		stmt.setString(4,strsdate);
		stmt.setString(5,stredate);
		stmt.setString(6,str912);
		stmt.setString(7,str1215);
		stmt.setString(8,str1518);
		stmt.setString(9,str1821);
		stmt.setString(10,strgprice);
		stmt.setString(11,strsprice);
		stmt.setString(12,striname);
		
		stmt.executeUpdate();
		System.out.println("data inserted into tablemovies");
		//dispTblmovies()
	con.close();
	stmt.close();
	}

	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void disTblmovies() 
	{
		Connection con=getdbconwithoracle();
				try {
					
					PreparedStatement stmt=con.prepareStatement("select * from tblmovies");
					
					ResultSet rset=stmt.executeQuery();
					
					
					while(rset.next())
					{
						
						String strmid,strname,strstar,strsdate, stredate,  str912, str1215, str1518, str1821,  strgprice, strsprice,  striname;
						strmid=rset.getString("movieid");
						strname=rset.getString("moviename");
						strstar=rset.getString("stars");
						strsdate=rset.getString("startdate");
						stredate=rset.getString("enddate");
						str912=rset.getString("slot912");
						str1215=rset.getString("slot1215");
						str1518=rset.getString("slot1518");
						str1821=rset.getString("slot1821");
						strgprice=rset.getString("goldprice");
						strsprice=rset.getString("silverprice");
						striname=rset.getString("imagename");
	System.out.println(strmid+strname+strstar+strsdate+ stredate+str912+str1215+ str1518+ str1821+strgprice+ strsprice+ striname);
					}
					con.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void delfromtablemoviesbyid(String strid) 
	{
	Connection con=getdbconwithoracle();


		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from tblmovies where movieid=?");
			stmt.setString(1,strid);
			stmt.executeUpdate();
			System.out.println("data delted");
			stmt.close();
			con.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
	}

	public Vector<String> getidfromtablemovies()
	{
		Vector<String> vctrid=new Vector<String>();
		
		Connection con=getdbconwithoracle();
		try
		{
			
			PreparedStatement stmt= con.prepareStatement("select movieid from tblmovies order by movieid");
		
			ResultSet rset=stmt.executeQuery();
			
			while(rset.next())
			{
				String strid;
				strid=rset.getString("movieid");
				vctrid.add(strid);
				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
			}
		
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return vctrid;
		
	}

//	public clsmov getmoviedetailbyid(String strid)
//	{
//		clsmov objci=null;
//		
//		
//		Connection con=getdbconwithoracle();
//		try
//		{
//			PreparedStatement stmt= con.prepareStatement("select * from tblmovies where movieid=?");
//			stmt.setString(1,strid);
//			ResultSet rset=stmt.executeQuery();
//			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
//			if(rset.next())
//			{
//				String strmid,strname,strstar,strsdate,stredate,str912,str1215,str1518,str1821,strgprice,strsprice,striname;
//				strmid=rset.getString("movieid");
//				strname=rset.getString("moviename");
//				strstar=rset.getString("stars");
//				strsdate=rset.getString("startdate");
//				stredate=rset.getString("enddate");
//				str912=rset.getString("slot912");
//				str1215=rset.getString("slot1215");
//				str1518=rset.getString("slot1518");
//				str1821=rset.getString("slot1821");
//				strgprice=rset.getString("goldprice");
//				strsprice=rset.getString("silverprice");
//				striname=rset.getString("imagename");
//				objci=new clsmov(strmid, strname,strstar,strsdate,stredate,str912,str1215,str1518,str1821,strgprice,strsprice,striname);
//				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null,"no record found");
//			}
//			con.close();//to close tht connection'
//		
//			stmt.close();//to close tht statement
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//
//	return objci;
//		// TODO Auto-generated method stub
//
//	}

	public void updatefromtablemoviesbyid(String strname, String strstar,
			String strsdate, String stredate, String str912, String str1215,
			String str1518, String str1821, String strgprice, String strsprice, String striname,String strmid)
	{
		Connection con=getdbconwithoracle();
		PreparedStatement stmt;
		try {
			
		stmt=con.prepareStatement("update tblmovies set moviename=?,stars=?,startdate=?,enddate=?,slot912=?,slot1215=?,slot1518=?,slot1821=?,goldprice=?,silverprice=?,imagename=? where movieid=?");
			System.out.println("enterd");
			stmt.setString(1,strname);
			stmt.setString(2,strstar);
			stmt.setString(3,strsdate);
			stmt.setString(4,stredate);
			stmt.setString(5,str912);
			stmt.setString(6,str1215);
			stmt.setString(7,str1518);
			stmt.setString(8,str1821);
			stmt.setString(9,strgprice);
			stmt.setString(10,strsprice);
			stmt.setString(11,striname);
			stmt.setString(12,strmid);
			
			
			stmt.executeUpdate();
			System.out.println("data updated into tablemovies");
		
		con.close();
		stmt.close();
		}

		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
	}

	public void insertuserdetailintouserreg(String urid, String urnm,
			String urpwd, String ureid, String urmob)
	{
		Connection con=getdbconwithoracle();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into userregister values(?,?,?,?,?)");
			stmt.setString(1,urid);
			stmt.setString(2,urnm);
			stmt.setString(3,urpwd);
			stmt.setString(4,ureid);
			stmt.setString(5,urmob);
			
			stmt.executeUpdate();
			System.out.println("data inserted into useregissted");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void insertintouserlogin(String uid, String upwd)
	{
		Connection con=getdbconwithoracle();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into userlogin values(?,?)");
			stmt.setString(1,uid);
			stmt.setString(2,upwd);
				
			stmt.executeUpdate();
			System.out.println("data inserted into user");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public boolean isvalidclient(String uid, String upwd)
	{
		boolean res=false;
		Connection con=getdbconwithoracle();
	// stmt;

		
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("select * from userlogin where userid=? and upwd=? ");
				stmt.setString(1,uid);
				stmt.setString(2,upwd);
				
				ResultSet rset=stmt.executeQuery();
				//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
				if(rset.next())
				{
					res=true;
				}
				else
				{
					res=false;
					
				}
			
			
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
			

		
	}

	public String getMaxticktidFromtblticket() 
	{
		// TODO Auto-generated method stub
		String strmaxtId="0";
		int tid=getMaxtId("TABLETICKET","TICKETID");
		strmaxtId=String.valueOf(tid);
		return strmaxtId;

	}

	private int getMaxtId(String strTblnm, String strcolnm) 
	{
		int maxtId=0;
		Connection con=getdbconwithoracle();
		
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+strcolnm+")as ticketid from tblticket");
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				maxtId=rset.getInt("ticketid");
			}
			else
			{
				maxtId=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return maxtId+1;
		
		
	}

	public void insertintotblticket(String struid, String strmid,String strtid, String strunm,
			String strumob, String strueid, String strgseatbooked, String strsseatbooked,
			String strdateofshow , String strslot, String strtotalprice)
	{

		Connection con=getdbconwithoracle();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into tblticket values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,struid);
			stmt.setString(2,strmid);
			stmt.setString(3,strtid);
			stmt.setString(4,strunm);
			stmt.setString(5,strumob);
			stmt.setString(6,strueid);
			stmt.setString(7,strgseatbooked);
			stmt.setString(8,strsseatbooked);
			stmt.setString(9,strdateofshow);
			stmt.setString(10,strslot);
			stmt.setString(11,strtotalprice);
			
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableticket");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void insertintotblseatbooked(String struid, String strmid, String totalgseats,
			String totalsseats, String strgoldseatbooked, String strsilverseatbooked, String strdateofshow,
			String strgoldseatsremaining, String strsilverseatsavailable, String strslotofshow)
	{

		Connection con=getdbconwithoracle();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into tblseatsbooked values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,struid);
			stmt.setString(2,strmid);
			stmt.setString(3,totalgseats);
			stmt.setString(4,totalsseats);
			stmt.setString(5,strgoldseatbooked);
			stmt.setString(6,strsilverseatbooked);
			stmt.setString(7,strdateofshow);
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


	public String dispgoldseatbooked(String strmid) 
	{
		String strgld = null;
		Connection con=getdbconwithoracle();
		try
		{
			PreparedStatement stmt= con.prepareStatement("select goldseatsbooked from tblseatsbooked where movieid=?");
			stmt.setString(1,strmid);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				
				strgld=rset.getString("goldseatsbooked");
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"no record found");
				//new Ticketstatusform(objci);
			}
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
	}

	return strgld;
		// TODO Auto-generated method stub

	}



	public void updatesilverseatsbooked(String strsilverseats, String strmid, String strtime)
	{
		Connection con=getdbconwithoracle();

		try {
			
			PreparedStatement stmt=con.prepareStatement("update tblseatsbooked set SILVERSEATSBOOKED=? where movieid=? and slotofshow=?");
			System.out.println("ethe hun bauji");
			stmt.setString(1,strsilverseats);
			stmt.setString(2,strmid);
			stmt.setString(3, strtime);
			
			
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


	public void updategoldseatsbooked(String strgoldseats, String strmid, String strtime)
	{
		Connection con=getdbconwithoracle();

		try {
			
			PreparedStatement stmt=con.prepareStatement("update tblseatsbooked set goldseatsbooked=? where movieid=? and slotofshow=?");

			stmt.setString(1,strgoldseats);
			stmt.setString(2,strmid);
			stmt.setString(3,strtime);
			
			
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



	public String dispsilverseatsbooked(String strmid) 
	{
		String strsilver=null;
		Connection con=getdbconwithoracle();
		try
		{
			PreparedStatement stmt= con.prepareStatement("select silverseatsbooked from tblseatsbooked where movieid=?");
			stmt.setString(1,strmid);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				
				strsilver=rset.getString("silverseatsbooked");
//				strsilver=rset.getString("silverseatsbooked");
//				strslot=rset.getString("slotofshow");
//				objci=new clsticket(strgld,strsilver,strslot);
				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
			}
			else
			{
				//JOptionPane.showMessageDialog(null,"no record found");
				//new Ticketstatusform(objci);
			}
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return strsilver;

//		return null;
	}

	//public String getgoldseatsbyidand912(String strmid)
	//{
//		String strgld=null;
//		Connection con=getdbconwithoracle();
//		try
//		{
//			PreparedStatement stmt= con.prepareStatement("select goldseatsbooked from tblseatsbooked where slotofshow movieid=? ");
//			stmt.setString(1,strmid);
//			ResultSet rset=stmt.executeQuery();
//			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
//			if(rset.next())
//			{
//				
//				strgld=rset.getString("goldseatsseatsbooked");
////				strsilver=rset.getString("silverseatsbooked");
////				strslot=rset.getString("slotofshow");
////				objci=new clsticket(strgld,strsilver,strslot);
//				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
//			}
//			else
//			{
//				//JOptionPane.showMessageDialog(null,"no record found");
//				//new Ticketstatusform(objci);
//			}
//			con.close();//to close tht connection'
	//	
//			stmt.close();//to close tht statement
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
	//
	//return strgld;
	//
	//	
	//}


	public Vector<String> getmovienamefromtblmovies()
	{
		Vector<String> vctrmname=new Vector<String>();
		
		Connection con=getdbconwithoracle();
		try
		{
			
			PreparedStatement stmt= con.prepareStatement("select moviename from tblmovies order by movieid");
		
			ResultSet rset=stmt.executeQuery();
			
			while(rset.next())
			{
				String strmname;
				strmname=rset.getString("moviename");
				vctrmname.add(strmname);
				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
			}
		
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return vctrmname;
		
		
	}

//	public clsmov getmoviedetailbyname(String strmoviename)
//	{
//		// TODO Auto-generated method stub
//		clsmov objci=null;
//		
//		
//		Connection con=getdbconwithoracle();
//		try
//		{
//			PreparedStatement stmt= con.prepareStatement("select * from tblmovies where moviename=?");
//			stmt.setString(1,strmoviename);
//			ResultSet rset=stmt.executeQuery();
//			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
//			if(rset.next())
//			{
//				String strmid,strname,strstar,strsdate,stredate,str912,str1215,str1518,str1821,strgprice,strsprice,striname;
//				strmid=rset.getString("movieid");
//				strname=rset.getString("moviename");
//				strstar=rset.getString("stars");
//				strsdate=rset.getString("startdate");
//				stredate=rset.getString("enddate");
//				str912=rset.getString("slot912");
//				str1215=rset.getString("slot1215");
//				str1518=rset.getString("slot1518");
//				str1821=rset.getString("slot1821");
//				strgprice=rset.getString("goldprice");
//				strsprice=rset.getString("silverprice");
//				striname=rset.getString("imagename");
//				objci=new clsmov(strmid, strname,strstar,strsdate,stredate,str912,str1215,str1518,str1821,strgprice,strsprice,striname);
//				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null,"no record found");
//			}
//			con.close();//to close tht connection'
//		
//			stmt.close();//to close tht statement
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//
//	return objci;
//
//	}

	public clsuser getdetailsofuser(String userid)
	{
	clsuser objci=null;
		
		
		Connection con=getdbconwithoracle();
		try
		{
			PreparedStatement stmt= con.prepareStatement("select * from userregister where userid=?");
			stmt.setString(1,userid);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				String struid,struname,strmob,emailid,strpassword;
				struid=rset.getString("UserId");
				struname=rset.getString("uname");
				strmob=rset.getString("umob");
				strpassword=rset.getString("upwd");
				emailid=rset.getString("ueid");
				
				objci=new clsuser(struid,struname,strmob,strpassword,emailid);
				//System.out.println(strEmpno+"  "+strEname+"  "+strEage+"  "+strEadd+"  "+strEsal);
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

	return objci;

		
	}

	public String getMaxuserIdfromuserregister()
	{
		String strmaxId="0";
		int id=getMaxuId("userregister","userid");
		strmaxId=String.valueOf(id);
		return strmaxId;

	}

	private int getMaxuId(String tblname, String strcolnM)
	{
		int maxId=0;
		Connection con=getdbconwithoracle();
		
		try {
			PreparedStatement stmt=con.prepareStatement("select max("+strcolnM+")as id from userregister");
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
		  
		return maxId+1;
		
	}

	public void insertintouseroffertable(String struid, String strcode)
	{
		Connection con=getdbconwithoracle();

		try {
			PreparedStatement stmt=con.prepareStatement("insert into tbluseroffer values(?,?)");
			stmt.setString(1,struid);
			stmt.setString(2,strcode);
			
			stmt.executeUpdate();
			System.out.println("data inserted into tableuseroffer succesfully");
			//dispTblmovies()
		con.close();
		stmt.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public String getcodefromtableuserofferbyid(String struid)
	{
		
		String strcode=null;
		Connection con=getdbconwithoracle();
		try
		{
			PreparedStatement stmt= con.prepareStatement("select offercode from tbluseroffer where userid=?");
			stmt.setString(1,struid);
			ResultSet rset=stmt.executeQuery();
			//result set points to 1st row of query//mtlb pehli row mil jaegi hmko
			if(rset.next())
			{
				
				strcode=rset.getString("offercode");

			}
			else
			{
				//JOptionPane.showMessageDialog(null,"no record found");
				//new Ticketstatusform(objci);
			}
			con.close();//to close tht connection'
		
			stmt.close();//to close tht statement
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return strcode;

	}
}