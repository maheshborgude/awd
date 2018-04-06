package buisness.util.datastructures.dashboard.provider;

import configuration.Setup;


/**
 * This class is used to compare Dashboard>>Provider or Dashboard>>Location grid from the UI and Database 
 *This class implements Comparable<LocationProviderGridRow>
 * @author Sachin.Gawade
 * Date 1 March 2016
 */

	
	public class ProviderLocationGridRow implements Comparable<ProviderLocationGridRow> {

		
		private String	name;
		private String 	exceeding ;
		private String 	below;

/**
 * Parameterized ProviderLocationGridRow constructor
 * @param name: Provider or Location name
 * @param exceeding: Exceeding count 
 * @param below: Below count
 */
		 ProviderLocationGridRow(String name,String exceeding,String below)
		{
			this.name = name;
			this.exceeding = exceeding; 
			this.below = below;
		}		
/**
 * @return Provider or Location name
 */
		public String getName() {
			return name;
		}
/**
 * @return Exceeding count 
 */
		public String getExceeding() {
			return exceeding;
		}
/**
 * @return Below count
 */
		public String getBelow() {
			return below;
		}


		/**
		 * This method is used to compare the one object with target object or specified object <p>
		 * @param exactmatch: Row to compare with
		 * returns 0 if location/provider, exceeding, below matches<p>
		 * returns 1 if location/provider, exceeding, below not matches<p>
		 */
		@Override
		public int compareTo(ProviderLocationGridRow exactmatch) {
			
			
			try{
			if(this.name.compareToIgnoreCase(exactmatch.name)==0)
			{
				
				if(this.exceeding.compareToIgnoreCase(exactmatch.exceeding)==0)
				{
					
					if(this.below.compareToIgnoreCase(exactmatch.below)==0)
							{
								return 0;	
							}
						else
							{
								 Setup.log.debug("Data in Below column does not match for "+exactmatch.below+" "+exactmatch.below);
								return 1;
							}
					}
						 else 
							{
								Setup.log.debug("Data in Exceeding column does not match for "+exactmatch.exceeding+" "+exactmatch.exceeding);
								return 1;	
							}
					}		
					     else 
					        {
						       Setup.log.debug("Data in Location/Provider column does not match for "+exactmatch.name+" "+exactmatch.name);
						       return 1;	
					        }
		}
			catch(NullPointerException e)
			{
				 Setup.log.error("Null data is being compared.");
				 return 1;	
			}
			
			       }	 
				               
			          //return -1;
		}





