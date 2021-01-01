package bookmyshow;

public class clsfinal 
{
	String strmoviename, strgoldseats, strsilverseats,struid,  struname,  strshow,strcurrentdate;
	String qty;
	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}



	String strsumtotal;


	public String getStrsumtotal() {
		return strsumtotal;
	}

	public void setStrsumtotal(String strsumtotal)
	{
		this.strsumtotal = strsumtotal;
	}

	public String getStrmoviename() 
	{
		return strmoviename;
	}

	public void setStrmoviename(String strmoviename) {
		this.strmoviename = strmoviename;
	}

	public String getStrgoldseats() {
		return strgoldseats;
	}

	public void setStrgoldseats(String strgoldseats) {
		this.strgoldseats = strgoldseats;
	}

	public String getStrsilverseats() {
		return strsilverseats;
	}

	public void setStrsilverseats(String strsilverseats) {
		this.strsilverseats = strsilverseats;
	}

	public String getStruid() {
		return struid;
	}

	public void setStruid(String struid) {
		this.struid = struid;
	}

	public String getStruname() {
		return struname;
	}

	public void setStruname(String struname) {
		this.struname = struname;
	}

	public String getStrshow() {
		return strshow;
	}

	public void setStrshow(String strshow) {
		this.strshow = strshow;
	}

	public String getStrcurrentdate() {
		return strcurrentdate;
	}

	public void setStrcurrentdate(String strcurrentdate) {
		this.strcurrentdate = strcurrentdate;
	}


	
	public clsfinal()
	{
		
	}

	 

	public clsfinal(String strmoviename, String strgoldseats, String strsilverseats, String strsumtotal,
			String struid, String struname, String strshow, String strcurrentdate, String qty) 
	{
	this.strmoviename=strmoviename;
	this.strgoldseats=strgoldseats;
	this.strsilverseats=strsilverseats;
	this.strsumtotal=strsumtotal;
	this.struid=struid;
	this.struname=struname;
	this.strcurrentdate=strcurrentdate;
	this.strshow=strshow;
	this.qty=qty;
	
	}

}
