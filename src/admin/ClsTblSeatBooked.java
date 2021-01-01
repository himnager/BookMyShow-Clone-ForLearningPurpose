package admin;
//desc tblseatbooked
//Name             Null Type          
//---------------- ---- ------------- 
//ID                    NUMBER(10)    
//MOVIEID               NUMBER(8)     
//TTLGOLDSEATS          NUMBER(8)     
//TTLSILVERSEATS        NUMBER(8)     
//GOLDSEATBOOKED        VARCHAR2(300) 
//SILVERSEATBOOKED      VARCHAR2(300) 
//DATEOFSHOW            DATE          
//GOLDAVAILSEATS        NUMBER(8)     
//SILVERAVAILSEATS      NUMBER(8)     
//SLOTOFSHOW            VARCHAR2(10)  

import java.sql.Date;

public class ClsTblSeatBooked {

	int id,movieid,ttlGoldSeats,ttlSilverSeats,goldAvailseats,silverAvailSeats;
	String strSlotOfShow,strGoldSeatsBooked,strSilverSeatsBooked;
	Date dateOfShow;
	
	@Override
	public String toString() {
		return "ClsTblSeatBooked [id=" + id + ", movieid=" + movieid + ", ttlGoldSeats=" + ttlGoldSeats
				+ ", ttlSilverSeats=" + ttlSilverSeats + ", goldAvailseats=" + goldAvailseats + ", silverAvailSeats="
				+ silverAvailSeats + ", strSlotOfShow=" + strSlotOfShow + ", strGoldSeatsBooked=" + strGoldSeatsBooked
				+ ", strSilverSeatsBooked=" + strSilverSeatsBooked + ", dateOfShow=" + dateOfShow + "]";
	}
	public ClsTblSeatBooked() {
		super();
	}
	public ClsTblSeatBooked(int id, int movieid, int ttlGoldSeats, int ttlSilverSeats, int goldAvailseats,
			int silverAvailSeats, String strSlotOfShow, String strGoldSeatsBooked, String strSilverSeatsBooked,
			Date dateOfShow) {
		super();
		this.id = id;
		this.movieid = movieid;
		this.ttlGoldSeats = ttlGoldSeats;
		this.ttlSilverSeats = ttlSilverSeats;
		this.goldAvailseats = goldAvailseats;
		this.silverAvailSeats = silverAvailSeats;
		this.strSlotOfShow = strSlotOfShow;
		this.strGoldSeatsBooked = strGoldSeatsBooked;
		this.strSilverSeatsBooked = strSilverSeatsBooked;
		this.dateOfShow = dateOfShow;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getTtlGoldSeats() {
		return ttlGoldSeats;
	}
	public void setTtlGoldSeats(int ttlGoldSeats) {
		this.ttlGoldSeats = ttlGoldSeats;
	}
	public int getTtlSilverSeats() {
		return ttlSilverSeats;
	}
	public void setTtlSilverSeats(int ttlSilverSeats) {
		this.ttlSilverSeats = ttlSilverSeats;
	}
	public int getGoldAvailseats() {
		return goldAvailseats;
	}
	public void setGoldAvailseats(int goldAvailseats) {
		this.goldAvailseats = goldAvailseats;
	}
	public int getSilverAvailSeats() {
		return silverAvailSeats;
	}
	public void setSilverAvailSeats(int silverAvailSeats) {
		this.silverAvailSeats = silverAvailSeats;
	}
	public String getStrSlotOfShow() {
		return strSlotOfShow;
	}
	public void setStrSlotOfShow(String strSlotOfShow) {
		this.strSlotOfShow = strSlotOfShow;
	}
	public String getStrGoldSeatsBooked()
	{
		try
		{
		if(strGoldSeatsBooked.equals("null") || strSilverSeatsBooked==null)
		{
			return "";
		}
		}
		catch(NullPointerException npe)
		{
			return "";
		}
		return strGoldSeatsBooked;
	}
	public void setStrGoldSeatsBooked(String strGoldSeatsBooked) {
		this.strGoldSeatsBooked = strGoldSeatsBooked;
	}
	public String getStrSilverSeatsBooked() 
	{
		try
		{
			if(strSilverSeatsBooked.equals("null") || strSilverSeatsBooked==null)
			{
				return "";
			}
		}
		catch(NullPointerException npe)
		{
			return "";
		}
		return strSilverSeatsBooked;
	}
	public void setStrSilverSeatsBooked(String strSilverSeatsBooked) {
		this.strSilverSeatsBooked = strSilverSeatsBooked;
	}
	public Date getDateOfShow() {
		return dateOfShow;
	}
	public void setDateOfShow(Date dateOfShow) {
		this.dateOfShow = dateOfShow;
	}
}
