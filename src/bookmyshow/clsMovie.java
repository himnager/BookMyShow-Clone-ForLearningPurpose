package bookmyshow;

import java.sql.Date;

import javax.swing.JTextField;

//desc tblmovies
//Name        Null Type         
//----------- ---- ------------ 
//MOVIEID          NUMBER(5)    
//MOVIENAME        VARCHAR2(20) 
//STARS            VARCHAR2(5)  
//STARTDATE        DATE         
//ENDDATE          DATE         
//SLOT912          VARCHAR2(10) 
//SLOT1215         VARCHAR2(10) 
//SLOT1518         VARCHAR2(10) 
//SLOT1821         VARCHAR2(10) 
//GOLDPRICE        NUMBER(3)    
//SILVERPRICE      NUMBER(3)    
//IMAGENAME        VARCHAR2(20) 
//LANGUAGE         VARCHAR2(20) 
public class clsMovie 
{
	 
	String strMovieId,strMovieName,strStars,strSlot912,strSlot1215,strSlot1518,strSlot1821,strImageName,strLanguage;
	Date dtStartDate,dtEndDate;
	double dblGoldPrice,dblSilverPrice;
	
	
	@Override
	public String toString() {
		return "clsMovie [strMovieId=" + strMovieId + ", strMovieName=" + strMovieName + ", strStars=" + strStars
				+ ", strSlot912=" + strSlot912 + ", strSlot1215=" + strSlot1215 + ", strSlot1518=" + strSlot1518
				+ ", strSlot1821=" + strSlot1821 + ", strImageName=" + strImageName + ", strLanguage=" + strLanguage
				+ ", dtStartDate=" + dtStartDate + ", dtEndDate=" + dtEndDate + ", dblGoldPrice=" + dblGoldPrice
				+ ", dblSilverPrice=" + dblSilverPrice + "]";
	}
	public clsMovie() {
		super();
	}
	public clsMovie(String strMovieId, String strMovieName, String strStars, String strSlot912, String strSlot1215,
			String strSlot1518, String strSlot1821, String strImageName, String strLanguage, Date dtStartDate,
			Date dtEndDate, double dblGoldPrice, double dblSilverPrice) {
		super();
		this.strMovieId = strMovieId;
		this.strMovieName = strMovieName;
		this.strStars = strStars;
		this.strSlot912 = strSlot912;
		this.strSlot1215 = strSlot1215;
		this.strSlot1518 = strSlot1518;
		this.strSlot1821 = strSlot1821;
		this.strImageName = strImageName;
		this.strLanguage = strLanguage;
		this.dtStartDate = dtStartDate;
		this.dtEndDate = dtEndDate;
		this.dblGoldPrice = dblGoldPrice;
		this.dblSilverPrice = dblSilverPrice;
	}
	public String getStrMovieId() {
		return strMovieId;
	}
	public void setStrMovieId(String strMovieId) {
		this.strMovieId = strMovieId;
	}
	public String getStrMovieName() {
		return strMovieName;
	}
	public void setStrMovieName(String strMovieName) {
		this.strMovieName = strMovieName;
	}
	public String getStrStars() {
		return strStars;
	}
	public void setStrStars(String strStars) {
		this.strStars = strStars;
	}
	public String getStrSlot912() {
		return strSlot912;
	}
	public void setStrSlot912(String strSlot912) {
		this.strSlot912 = strSlot912;
	}
	public String getStrSlot1215() {
		return strSlot1215;
	}
	public void setStrSlot1215(String strSlot1215) {
		this.strSlot1215 = strSlot1215;
	}
	public String getStrSlot1518() {
		return strSlot1518;
	}
	public void setStrSlot1518(String strSlot1518) {
		this.strSlot1518 = strSlot1518;
	}
	public String getStrSlot1821() {
		return strSlot1821;
	}
	public void setStrSlot1821(String strSlot1821) {
		this.strSlot1821 = strSlot1821;
	}
	public String getStrImageName() {
		return strImageName;
	}
	public void setStrImageName(String strImageName) {
		this.strImageName = strImageName;
	}
	public String getStrLanguage() {
		return strLanguage;
	}
	public void setStrLanguage(String strLanguage) {
		this.strLanguage = strLanguage;
	}
	public Date getDtStartDate() {
		return dtStartDate;
	}
	public void setDtStartDate(Date dtStartDate) {
		this.dtStartDate = dtStartDate;
	}
	public Date getDtEndDate() {
		return dtEndDate;
	}
	public void setDtEndDate(Date dtEndDate) {
		this.dtEndDate = dtEndDate;
	}
	public double getDblGoldPrice() {
		return dblGoldPrice;
	}
	public void setDblGoldPrice(double dblGoldPrice) {
		this.dblGoldPrice = dblGoldPrice;
	}
	public double getDblSilverPrice() {
		return dblSilverPrice;
	}
	public void setDblSilverPrice(double dblSilverPrice) {
		this.dblSilverPrice = dblSilverPrice;
	}
	
	
}
