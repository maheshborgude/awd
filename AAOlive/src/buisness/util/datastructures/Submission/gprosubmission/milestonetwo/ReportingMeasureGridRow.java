package buisness.util.datastructures.Submission.gprosubmission.milestonetwo;

import configuration.Setup;

/** This Class is used inorder to store pqrsno, measuretitle, qualitydomain and crosscutting from an row.<p>
 * This class implements Comparable interface.<p>
 * @author Sachin Gawade <p>
 * 11 Feb 2016
 */

public class ReportingMeasureGridRow  implements Comparable<ReportingMeasureGridRow> {

	
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
 * Intializes pqrsno,measuretitle,qualitydomain,crosscutting for an GproMeasureGridRow object.<p>
 * @param String pqrsno measure number
 * @param String measuretitle measure name
 * @param String qualitydomain quality domain of measure
 * @param String crosscutting if the measure is cross cutting or not
 * 
 * @author Sachin Gawade <p>
 * 11 Feb 2016
 */

	ReportingMeasureGridRow (String pqrsno,String measuretitle,String qualitydomain,String crosscutting)
	{
		this.pqrsno = pqrsno;
		this.measuretitle = measuretitle; 
		this.qualitydomain = qualitydomain;
		this.crosscutting = crosscutting;
	}
	
	
	/**compareTo method<p>
	 * Compares pqrsno,measuretitle,qualitydomain,crosscutting for two object of GproMeasureGridRow class.</br>
	 * Returns 0 is all variables of a row match with target row<p>
	 * Returns 1 is any variable of a row does not match with target row<p>
	 * @author Sachin Gawade <p>
     * 11 Feb 2016
	 */
	@Override
	public int compareTo(ReportingMeasureGridRow exactmatch) {
	
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
