package buisness.util.datastructures.administration.location;

import configuration.Setup;

/**
/** This Class is used in order to store locationname, City, State, postalcode2, Inactive from an row.<p>
 * This class implements Comparable interface.<p>
 * @author nilesh.patil
 * created date 12 Jan 2016
 *
 */
 class LocationGridrow implements Comparable<LocationGridrow> {

	
	private String	locationname;
	private String 	City;
	private String 	State;
	private String 	Postalcode;
	private String 	Inactive;

	 LocationGridrow(String locationname,String City,String State,String postalcode2,String Inactive)
	{
		this.locationname = locationname;
		this.City = City; 
		this.State = State;
		this.Postalcode = postalcode2;
		this.Inactive = Inactive;
	}
	
	public String getLocationname() {
		return locationname;
	}

	public String getCity() {
		return City;
	}

	public String getState() {
		return State;
	}

	public String getPostalcode() {
		return Postalcode;
	}

	public String getInactive() {
		return Inactive;
	}

	
	/**
	 * This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if locationname ,City,State,Postalcode,and Inactive matches<p>
	 * returns 1 if locationname ,City,State,Postalcode,and Inactive not matches<p>
	 */
	@Override
	public int compareTo(LocationGridrow exactmatch) {
		
		if(this.locationname.compareToIgnoreCase(exactmatch.locationname)==0)
		{
			if(this.City.compareToIgnoreCase(exactmatch.City)==0)
			{
				if(this.State.compareToIgnoreCase(exactmatch.State)==0)
				{
					if(this.Postalcode.compareToIgnoreCase(exactmatch.Postalcode)==0)
					{
						if(this.Inactive.compareToIgnoreCase(exactmatch.Inactive)==0)
						{
							return 0;	
						}
					else
						{
							 Setup.log.debug("Data in locationname column does not match for "+exactmatch.locationname+" "+exactmatch.locationname);
							return 1;
						}
				}
					 else 
						{
							Setup.log.debug("Data in City column does not match for "+exactmatch.City+" "+exactmatch.City);
							return 1;	
						}
				}		
				     else 
				        {
					       Setup.log.debug("Data in State column does not match for "+exactmatch.State+" "+exactmatch.State);
					       return 1;	
				        }
		       }	 else
			            {
			        	   Setup.log.debug("Data in Postalcode column does not match for "+exactmatch.Postalcode+" "+exactmatch.Postalcode);
					       return 1;
			             }
			   }     else
			             {
				           Setup.log.debug("Data in Inactive column does not match for "+exactmatch.Inactive+" "+exactmatch.Inactive);
			               return 1;
		
			               }
		          //return -1;
	}


}



