package buisness.awadhesh.datastructures.pro;
import buisness.util.datastructures.administration.usermanagement.UsermangementGridRow;
import configuration.Setup;


/**
/** This Class is used in order to store Patients,age from  row.<p>
 * This class implements Comparable interface.<p>
 *
 */
public class Patientlistgridrow implements Comparable<Patientlistgridrow>{


	private String	Patients;
	private String 	age;
	
	Patientlistgridrow(String patients, String age)
	{
	this.Patients = patients;
	this.age = age;
	}
	
	public String getpatient(){
    return Patients;
     }
	public String getage(){
	    return age;
	     }
	
	
	/**
	/** This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if firstname,middlename,lastname,practiceid,practicename,loginame,inactive matches<p>
	 * returns 1 if firstname,middlename,lastname,practiceid,practicename,loginame,inactive not matches<p>
	 */
	@Override
	public int compareTo(Patientlistgridrow exactmatch) {
		if(this.Patients.compareToIgnoreCase(exactmatch.Patients)==0)
		{
			if(this.age.compareToIgnoreCase(exactmatch.age)==0)
			{
			
		}
		
		
	}
		return 0;
		
	
	
	
	
	
	}}
	



