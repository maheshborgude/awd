package buisness.util.datastructures.administration.provider;
import configuration.Setup;

/** This Class is used inorder to store firstname,middlename,lastname,emailaddress,npi,inactive from an row.<p>
 * This class implements Comparable interface.<p>
 * @author Sachin Gawade <p>
 * 12 Jan 2016
 */

public class ProviderGridRow  implements Comparable<ProviderGridRow > {

	
	private String	firstname;
	private String 	middlename;
	private String 	lastname;
	private String 	emailaddress;
	private String 	npi;
	private String 	inactive;
	
	//getter method for firstname
	public String getFirstname() {
		return firstname;
	}

	//getter method for middlename
	public String getMiddlename() {
		return middlename;
	}

	//getter method for lastname
	public String getLastname() {
		return lastname;
	}

	//getter method for emailaddress
	public String getEmailaddress() {
		return emailaddress;
	}

	//getter method for npi
	public String getNpi() {
		return npi;
	}

	//getter method for inactive
	public String getInactive() {
		return inactive;
	}

/**
 * 	ProviderGridRow constructor. <p>
 * Intializes firstname,middlename,lastname,emailaddress,npi,inactive for an PopupProviderGridRow object.
 * @param String firstname
 * @param String middlename
 * @param String lastname
 * @param String emailaddress
 * @param String npi
 * @param String inactive
 * 
 * @author Sachin Gawade <p>
 * 12 Jan 2016
 */

	ProviderGridRow (String firstname,String middlename,String lastname,String emailaddress,String npi,String inactive)
	{
		this.firstname = firstname;
		this.middlename = middlename; 
		this.lastname = lastname;
		this.emailaddress = emailaddress;
		this.npi = npi;
		this.inactive = inactive;
	}
	
	
	/**compareTo method<p>
	 * Compares firstname,middlename,lastname,emailaddress,npi,inactive for two object of PopupProviderGridRow class.</br>
	 * Returns 0 is all variables of a row match with target row<p>
	 * Returns 1 is any variable of a row does not match with target row
	 * @author Sachin Gawade <p>
     * 12 Jan 2016
	 */
	@Override
	public int compareTo(ProviderGridRow exactmatch) {
		// TODO Auto-generated method stub
		
		if(this.firstname.equalsIgnoreCase(exactmatch.firstname))
		{
			if(this.middlename.equalsIgnoreCase(exactmatch.middlename))
			{
				if(this.lastname.equalsIgnoreCase(exactmatch.lastname))
				{
					if(this.emailaddress.equalsIgnoreCase(exactmatch.emailaddress))
					{
						if(this.npi.equalsIgnoreCase(exactmatch.npi))
						{
							if(this.inactive.equalsIgnoreCase(exactmatch.inactive))
							{
								return 0;
							}
							else
							{
								Setup.log.debug("Data in Inactive column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
								return 1;
							}
					}	
						else
						{
							Setup.log.debug("Data in NPI column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
							return 1;
						}
				}
					else
					{
						Setup.log.debug("Data in Email address column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
						return 1;
					}
			}
				else
				{
					Setup.log.debug("Data in Last Name column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
					return 1;
				}
				
		}
			else
			{
				Setup.log.debug("Data in Middle Name column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
				return 1;
			}
			
	}
		else
		{
			Setup.log.debug("Data in First Name column does not match for "+exactmatch.firstname+" "+exactmatch.lastname);
			return 1;
		}
		
	}
}
