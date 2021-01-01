package common;

import java.sql.Date;

import oracle.sql.BLOB;

public class clsMovie 
{

	int  intMovieId,intGoldPrice,intSilverPrice;
	
	String strMovieName,strMovieStar,strMovieLanguage
			,strSlot912,strSlot1215,strSlot1518,strSlot1821,strMovieImageName;
		
	Date strStartDate,strEndDate;
	
	//BLOB blobMovieImage;
	
	public clsMovie()
	{
		
	}

	public clsMovie(int intMovieId, int intGoldPrice, int intSilverPrice, String strMovieName, String strMovieStar,
			String strMovieLanguage, String strSlot912, String strSlot1215, String strSlot1518, String strSlot1821,
			Date strStartDate, Date strEndDate,String strMovieImageName) 
	{
		super();
		this.intMovieId = intMovieId;
		this.intGoldPrice = intGoldPrice;
		this.intSilverPrice = intSilverPrice;
		this.strMovieName = strMovieName;
		this.strMovieStar = strMovieStar;
		this.strMovieLanguage = strMovieLanguage;
		this.strSlot912 = strSlot912;
		this.strSlot1215 = strSlot1215;
		this.strSlot1518 = strSlot1518;
		this.strSlot1821 = strSlot1821;
		this.strStartDate = strStartDate;
		this.strEndDate = strEndDate;
		this.strMovieImageName = strMovieImageName;
	}


	public String getStrMovieImageName() {
		return strMovieImageName;
	}


	public void setStrMovieImageName(String strMovieImageName) {
		this.strMovieImageName = strMovieImageName;
	}


	public String toString() {
		return "clsMovie [intMovieId=" + intMovieId + ", intGoldPrice=" + intGoldPrice + ", intSilverPrice="
				+ intSilverPrice + ", strMovieName=" + strMovieName + ", strMovieStar=" + strMovieStar
				+ ", strMovieLanguage=" + strMovieLanguage + ", strSlot912=" + strSlot912 + ", strSlot1215="
				+ strSlot1215 + ", strSlot1518=" + strSlot1518 + ", strSlot1821=" + strSlot1821 + ", strStartDate="
				+ strStartDate + ", strEndDate=" + strEndDate + ", strMovieImageName=" +strMovieImageName + "]";
	}

	public int getIntMovieId() {
		return intMovieId;
	}

	public void setIntMovieId(int intMovieId) {
		this.intMovieId = intMovieId;
	}

	public int getIntGoldPrice() {
		return intGoldPrice;
	}

	public void setIntGoldPrice(int intGoldPrice) {
		this.intGoldPrice = intGoldPrice;
	}

	public int getIntSilverPrice() {
		return intSilverPrice;
	}

	public void setIntSilverPrice(int intSilverPrice) {
		this.intSilverPrice = intSilverPrice;
	}

	public String getStrMovieName() {
		return strMovieName;
	}

	public void setStrMovieName(String strMovieName) {
		this.strMovieName = strMovieName;
	}

	public String getStrMovieStar() {
		return strMovieStar;
	}

	public void setStrMovieStar(String strMovieStar) {
		this.strMovieStar = strMovieStar;
	}

	public String getStrMovieLanguage() {
		return strMovieLanguage;
	}

	public void setStrMovieLanguage(String strMovieLanguage) {
		this.strMovieLanguage = strMovieLanguage;
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

	public Date getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(Date strStartDate) {
		this.strStartDate = strStartDate;
	}

	public Date getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(Date strEndDate) {
		this.strEndDate = strEndDate;
	}

//	public BLOB getBlobMovieImage() {
//		return blobMovieImage;
//	}
//
//	public void setBlobMovieImage(BLOB blobMovieImage) {
//		this.blobMovieImage = blobMovieImage;
//	}
	
	
		
				
				
			
	
}
