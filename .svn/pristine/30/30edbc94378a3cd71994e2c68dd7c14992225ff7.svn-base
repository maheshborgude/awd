package buisness.util.datastructures.gprosubmission;

import configuration.Setup;

/** This Class is used inorder to store pqrsno, measuretitle, qualitydomain and crosscutting from an row.<p>
 * This class implements Comparable interface.<p>
 * @author Sachin Gawade <p>
 * 11 Feb 2016
 */

public class GproMeasureGridRow  implements Comparable<GproMeasureGridRow> {

	
	private String	pqrsno;
	private String 	measuretitle;
	private String 	qualitydomain;
	private String 	crosscutting;

	
	//getter method for pqrsno
	public String getPqrsno() {
		return pqrsno;
	}

	//getter method for measuretitle
	public String getMeasuretitle() {
		return measuretitle;
	}

	//getter method for qualitydomain
	public String getQualitydomain() {
		return qualitydomain;
	}

	//getter method for crosscutting
	public String getCrosscutting() {
		return crosscutting;
	}

/**
 * 	ProviderGridRow constructor. <p>
 * Intializes pqrsno,measuretitle,qualitydomain,crosscutting for an GproMeasureGridRow object.
 * @param String pqrsno
 * @param String measuretitle
 * @param String qualitydomain
 * @param String crosscutting
 * 
 * @author Sachin Gawade <p>
 * 11 Feb 2016
 */

	GproMeasureGridRow (String pqrsno,String measuretitle,String qualitydomain,String crosscutting)
	{
		this.pqrsno = pqrsno;
		this.measuretitle = measuretitle; 
		this.qualitydomain = qualitydomain;
		this.crosscutting = crosscutting;
	}
	
	
	/**compareTo method<p>
	 * Compares pqrsno,measuretitle,qualitydomain,crosscutting for two object of GproMeasureGridRow class.</br>
	 * Returns 0 is all variables of a row match with target row<p>
	 * Returns 1 is any variable of a row does not match with target row
	 * @author Sachin Gawade <p>
     * 11 Feb 2016
	 */
	@Override
	public int compareTo(GproMeasureGridRow exactmatch) {
		// TODO Auto-generated method stub
		
	
		if(this.pqrsno.equalsIgnoreCase(exactmatch.pqrsno))
		{
			
			if(this.measuretitle.equalsIgnoreCase(exactmatch.measuretitle))
			{
				
				if(this.qualitydomain.equalsIgnoreCase(exactmatch.qualitydomain.replaceAll("(\\r|\\n|\\r\\n)+", " ")))
				{
					
					if(this.crosscutting.equalsIgnoreCase(exactmatch.crosscutting))
					{
						
								return 0;
					}
							else
							{
								Setup.log.debug("Crosscutting does not match for measure"+exactmatch.pqrsno+" "+exactmatch.measuretitle);
								return 1;
							}
				}	
						else
						{
							Setup.log.debug("Quality domain does not match for measure"+exactmatch.pqrsno+" "+exactmatch.measuretitle);
							return 1;
						}
				}
					else
					{
						Setup.log.debug("Measure Title does not match for measure"+exactmatch.pqrsno+" "+exactmatch.measuretitle);
						return 1;
					}
			}
				else
				{
					Setup.log.debug("Measure Number does not match for measure"+exactmatch.pqrsno+" "+exactmatch.measuretitle);
					return 1;
				}
				
		}
			
}
