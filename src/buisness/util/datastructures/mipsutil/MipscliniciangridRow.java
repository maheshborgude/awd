package buisness.util.datastructures.mipsutil;


import configuration.Setup;

public class MipscliniciangridRow  implements Comparable<MipscliniciangridRow>  {

	private String	PROVIDERNAME;
	private String 	MIPSELIGIBILITY;
	private String 	NPI;
	private String 	TIN;
    private String 	QUALITY;
	private String 	ACI;
	private String 	IA;
	private String 	MIPSFINALSCORE;
    private String 	SUBMISSIONSTATUS;

	
	
	
	/**
	 * parameterized constructor with parameter  
	 * @param 
	 * @param 
	 * @param 
	 * @param 
	 */
    MipscliniciangridRow(String PROVIDERNAME, String MIPSELIGIBILITY, String NPI, String TIN,String QUALITY,String ACI,String IA,String MIPSFINALSCORE,String SUBMISSIONSTATUS)
	{
		this.PROVIDERNAME = PROVIDERNAME;
		this.MIPSELIGIBILITY = MIPSELIGIBILITY; 
		this.NPI = NPI;      
		this.TIN = TIN;
		this.QUALITY = QUALITY;
		this.ACI = ACI; 
		this.IA = IA;
		this.MIPSFINALSCORE = MIPSFINALSCORE;
		this.SUBMISSIONSTATUS = SUBMISSIONSTATUS;
	
		/*
		 * 
		 */
	}
    /**
	 * This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if PROVIDERNAME,MIPSELIGIBILITY,NPI,TIN,practicename,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS matches<p>
	 * returns 1 if PROVIDERNAME,MIPSELIGIBILITY,NPI,TIN,practicename,QUALITY,ACI,IA,MIPSFINALSCORE,SUBMISSIONSTATUS  not matches<p>
	 */
	@Override
	public int compareTo(MipscliniciangridRow exactmatch) {
		
		if(this.PROVIDERNAME.compareToIgnoreCase(exactmatch.PROVIDERNAME)==0)
		{
			if(this.MIPSELIGIBILITY.compareToIgnoreCase(exactmatch.MIPSELIGIBILITY)==0)
			{
				if(this.NPI.compareToIgnoreCase(exactmatch.NPI)==0)
				{
					if(this.TIN.compareToIgnoreCase(exactmatch.TIN)==0)
					{
						if(this.QUALITY.compareToIgnoreCase(exactmatch.QUALITY)==0)
						{
							if(this.ACI.compareToIgnoreCase(exactmatch.ACI)==0)

							{	if(this.IA.compareToIgnoreCase(exactmatch.IA)==0)
								{
									if(this.MIPSFINALSCORE.compareToIgnoreCase(exactmatch.MIPSFINALSCORE)==0)
							   {
						        if(this.SUBMISSIONSTATUS.compareToIgnoreCase(exactmatch.SUBMISSIONSTATUS)==0)
						    {
						            	return 0;	
						              }
					else
						{
							 Setup.log.debug("Data in SUBMISSIONSTATUS column does not match for "+exactmatch.SUBMISSIONSTATUS+" "+exactmatch.SUBMISSIONSTATUS);
							return 1;
						}
				}
						else
						{
							 Setup.log.debug("Data in MIPSFINALSCORE column does not match for "+exactmatch.MIPSFINALSCORE+" "+exactmatch.MIPSFINALSCORE);
							return 1;
						}
					}
					else
					{
						 Setup.log.debug("Data in IA column does not match for "+exactmatch.IA+" "+exactmatch.IA);
						return 1;
					}
				}
					 else 
						{
							Setup.log.debug("Data in ACI column does not match for "+exactmatch.ACI+" "+exactmatch.ACI);
							return 1;	
						}
				}		
				     else 
				        {
					       Setup.log.debug("Data in QUALITY column does not match for "+exactmatch.QUALITY+" "+exactmatch.QUALITY);
					       return 1;	
				        }
		       }	 else
			            {
			        	   Setup.log.debug("Data in TIN column does not match for "+exactmatch.TIN+" "+exactmatch.TIN);
					       return 1;
			             }
			   }     else
			             {
				           Setup.log.debug("Data in NPI column does not match for "+exactmatch.NPI+" "+exactmatch.NPI);
			                return 1;
			             }
	           } 
		            else {
		            	Setup.log.debug("Data in MIPSELIGIBILITY column does not match for "+exactmatch.MIPSELIGIBILITY+" "+exactmatch.MIPSELIGIBILITY);
		                return 1;

		                 }
	           }     
	                    else {
     	               Setup.log.debug("Data in PROVIDERNAME column does not match for "+exactmatch.PROVIDERNAME+" "+exactmatch.PROVIDERNAME);
                        return 1;

          }
	 
	 
             }
}        
	
                         
	

	
	
	




	

    

    
    
    
    

