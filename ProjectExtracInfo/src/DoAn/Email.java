package DoAn;

public class Email 
{
	String emailExtract;

	public String getEmailExtract() {
		return emailExtract;
	}

	public void setEmailExtract(String emailExtract) {
		this.emailExtract = emailExtract;
	}

	@Override
	public String toString() 
	{
		return "Email :"  + this.emailExtract;
	}
	
	
}
