package buisness.core.dashboard.Practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buisness.core.login.AfterLoginUtility;
import buisness.managers.DatabaseManger;
import configuration.Setup;

public class FavoriteMeasureID extends MeasureID
{
	private String FIGUseruid;
	@Override
	public List<String> getDBMeasureID() 
	{
		List<String> dbmeasureID = new ArrayList<String>();
		
		query = pr.getQuery("FavriteMeasureIDforRegistry");
		FIGUseruid = AfterLoginUtility.getFIGUerUID();
		
		query = query.replace("@FigUserUid", FIGUseruid);
		try
		{
			ResultSet rs = DatabaseManger.exeQueryWeb(query);
			String currentMeasureID = null;
			String RegistryName = pr.read_Configfile("RegistryNameForMeasure");
			while(rs.next())
			{
				currentMeasureID = rs.getString("MeasureID");
				// Measure ID are appended with registry name Eg. IPRO 01, so we have to append the our MeasureID from Database 
				currentMeasureID = RegistryName + " " + currentMeasureID;
				dbmeasureID.add(currentMeasureID);
			}
		}
		catch(SQLException e)
		{
			Setup.log.error("Error occur in featch data from databas");
			Setup.log.error(e);
		}
		catch( Exception e)
		{
			Setup.log.error("Error occur in featch data from databas");
		}
		return dbmeasureID;
	}
	
	@Override
	public boolean verifyMeasureID(String locator) 
	{
		// TODO Auto-generated method stub
		return super.verifyMeasureID(locator);
	}
}
