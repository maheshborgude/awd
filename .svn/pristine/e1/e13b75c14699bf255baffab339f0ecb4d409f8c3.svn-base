package buisness.util.datastructures.dashboard.practice.practiceProvider;

import configuration.Setup;

/**
 * This class is used to compare Dashboard>>Provider Patient drill down grid from the UI and Database 
 *This class implements Comparable<PatientDrillDownGridRow>
 *Compare To method of Comparable<T> interface compare source row and target row
 * @author Sachin.Gawade
 * Updated Date 2 March 2016
 */

public class PatientDrillDownGridRow implements Comparable<PatientDrillDownGridRow>
{
	
	String name;
	String mrn;
	String gender;
	String dob;
	static int i=0;

	/**
	 * PatientDrillDownGridRow parameterized constructor
	 * @param name: Patient name
	 * @param mrn: Patient mrn
	 * @param gender: Patient gender
	 * @param dob: Patient date of birth
	 */
	PatientDrillDownGridRow(String name,String mrn,String gender,String dob)
	{
		this.name = name;
		this.mrn = mrn; 
		this.gender = gender;
		this.dob = dob;
	}
	/**
	 * @return Patient name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return Patient mrn
	 */
	public String getMrn() 
	{
		return mrn;
	}

	/**
	 * @return Patient gender
	 */
	public String getGender() 
	{
		return gender;
	}

	/**
	 * @return Patient Date of birth
	 */
	public String getDob() 
	{
		return dob;
	}

	/**
	 * Prints all columns in row of a grid
	 */
	public void print()
	{
		Setup.log.info( name + "\t" +mrn + "\t" + gender + "\t" + dob );
	}
	
	@Override
	public int compareTo(PatientDrillDownGridRow target) 
	{
		  i++;
		  System.out.println("Table Row No-"+i+" UI and DB data");
		if(this.name.equals(target.name))
		{ System.out.println("UI PatientName:"+ this.name+"\tDB PatientName:"+target.name); 
			if(this.mrn.equals(target.mrn))
			{ System.out.println("UI PatientMRN:"+ this.mrn+"\tDB PatientMRN:"+target.mrn); 
				if(this.gender.equals(target.gender))
				{ System.out.println("UI PatientGender:"+ this.gender+"\tDB PatientGender:"+target.gender);
					if(this.dob.equals(target.dob))
					{  System.out.println("UI PatientDOB:"+ this.dob+"\tDB PatientDOB:"+target.dob);
						return 0;
					}
					else
					{
						 Setup.log.debug("Data in Date of Birth column does not match for "+this.dob+" "+target.dob);
						return 1;
					}
				}
				else {
					 Setup.log.debug("Data in Gender column does not match for "+this.gender+" "+target.gender);
					return 1;
				    }
				
				}
			else {
				 Setup.log.debug("Data in Mrn column does not match for "+this.mrn+" "+target.mrn);
				return 1;
				  }
		}
		else {
			 Setup.log.debug("Data in Name column does not match for "+this.name+" "+target.name);
			 return 1;
			  }
	}
	
}
