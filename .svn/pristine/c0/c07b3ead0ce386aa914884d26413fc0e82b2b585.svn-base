package buisness.util.datastructures.administration.usermanagement;

import configuration.Setup;

/**
/** This Class is used in order to store firstname,middlename,lastname,practiceid,practicename,loginame,inactive from an row.<p>
 * This class implements Comparable interface.<p>
 * @author nilesh.patil
 * created date 27 Jan 2016
 *
 */

public class UsermangementGridRow implements Comparable<UsermangementGridRow> {

	
	private String	firstname;
	private String 	middlename;
	private String 	lastname;
	private String 	practiceid;
	private String practicename;
	private String 	loginame;
	private String 	inactive;

	 UsermangementGridRow(String firstname,String middlename,String lastname,String practiceid,String practicename,String loginame,String inactive)
	{
		this.firstname = firstname;
		this.middlename = middlename; 
		this.lastname = lastname;
		this.practiceid = practiceid;
		this.practicename = practicename;
		this.loginame = loginame;
		this.inactive = inactive;
	}
	
	

	
	public String getFirstname() {
		return firstname;
	}




	public String getMiddlename() {
		return middlename;
	}




	public String getLastname() {
		return lastname;
	}




	public String getPracticeid() {
		return practiceid;
	}




	public String getPracticename() {
		return practicename;
	}




	public String getLoginame() {
		return loginame;
	}




	public String getInactive() {
		return inactive;
	}




	/**
	 * This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if firstname,middlename,lastname,practiceid,practicename,loginame,inactive matches<p>
	 * returns 1 if firstname,middlename,lastname,practiceid,practicename,loginame,inactive not matches<p>
	 */
	@Override
	public int compareTo(UsermangementGridRow exactmatch) {
		
		if(this.firstname.compareToIgnoreCase(exactmatch.firstname)==0)
		{
			if(this.middlename.compareToIgnoreCase(exactmatch.middlename)==0)
			{
				if(this.lastname.compareToIgnoreCase(exactmatch.lastname)==0)
				{
					if(this.practiceid.compareToIgnoreCase(exactmatch.practiceid)==0)
					{
						if(this.practicename.compareToIgnoreCase(exactmatch.practicename)==0)
						{
							if(this.loginame.compareToIgnoreCase(exactmatch.loginame)==0)
							{
						if(this.inactive.compareToIgnoreCase(exactmatch.inactive)==0)
						{
							return 0;	
						}
					else
						{
							 Setup.log.debug("Data in locationname column does not match for "+exactmatch.firstname+" "+exactmatch.firstname);
							return 1;
						}
				}
						else
						{
							 Setup.log.debug("Data in locationname column does not match for "+exactmatch.middlename+" "+exactmatch.middlename);
							return 1;
						}
					}
					else
					{
						 Setup.log.debug("Data in locationname column does not match for "+exactmatch.lastname+" "+exactmatch.lastname);
						return 1;
					}
				}
					 else 
						{
							Setup.log.debug("Data in City column does not match for "+exactmatch.practiceid+" "+exactmatch.practiceid);
							return 1;	
						}
				}		
				     else 
				        {
					       Setup.log.debug("Data in State column does not match for "+exactmatch.practicename+" "+exactmatch.practicename);
					       return 1;	
				        }
		       }	 else
			            {
			        	   Setup.log.debug("Data in Postalcode column does not match for "+exactmatch.loginame+" "+exactmatch.loginame);
					       return 1;
			             }
			   }     else
			             {
				           Setup.log.debug("Data in Inactive column does not match for "+exactmatch.inactive+" "+exactmatch.inactive);
			                return 1;
			             }
	}


}



