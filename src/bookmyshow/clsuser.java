package bookmyshow;

public class clsuser 
{
	String struid,struname,strmob,strpassword, emailid;
	
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

	public String getStrmob() {
		return strmob;
	}

	public void setStrmob(String strmob) {
		this.strmob = strmob;
	}

	public String getStrpassword() {
		return strpassword;
	}

	public void setStrpassword(String strpassword) {
		this.strpassword = strpassword;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

public clsuser()
{
	
}

public clsuser(String struid, String struname, String strmob,
		String strpassword, String emailid)
{
	this.struid=struid;
	this.struname=struname;
	this.strmob=strmob;
	this.strpassword=strpassword;
	this.emailid=emailid;


}
}
