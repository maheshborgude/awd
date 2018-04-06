package buisness.managers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import configuration.Setup;


/**
 * This class is used to connect with Different database
 *  -WebDatabase
 *  -ManagementDataabase
 *  -CDRDatabase 
 *
 * @author rakesh.kulkarni
 * Date : 19-01-2015
 */
public class DatabaseManger {

	static Connection conn=null;
	static ConfigurationManager configmanager=new ConfigurationManager();
	static Hashtable<String, String> hashtable=configmanager.getDatabaseProperties();
	static String DbDriver = hashtable.get("Driver");
	static String DbConncetinString = hashtable.get("ConncetinString");
	static String DbUserName = hashtable.get("UserName");
	static String DbPassword = hashtable.get("Password");
	static String DbTypeWebdemo=hashtable.get("WebDemoDatabase");
	static String DbTypeManagmt=hashtable.get("ManagementDatabase");
	static String DbTypeCDR=hashtable.get("CDRDatabase");
	static String conStrofManagement =DbConncetinString + ";database=" + DbTypeManagmt ;
	static String conStrofWebdemo=DbConncetinString + ";database=" + DbTypeWebdemo ;
	static String conStrofcdr=DbConncetinString + ";database=" + DbTypeCDR ;

	/**
	 * This method connects with Management Database
	 *   -where Key Value is 'ManagementDatabase' in properties file
	 */
	public  static void  SQLserverConnection()  {
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofManagement);
			conn= DriverManager.getConnection(conStrofManagement,DbUserName,DbPassword);
			System.out.println("DB connection is established successfully.");
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());

		}
	}
	/**
	 * This method connects with Management Database
	 * Get query and execute
	 *    -where Key Value is 'ManagementDatabase' in properties file
	 * @return List of First result
	 */
	public static List<String> getQuery(String query)
	{
		List<String> values = new ArrayList<String>();
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofManagement);
			conn= DriverManager.getConnection(conStrofManagement,DbUserName,DbPassword);
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery(query);
			while(rs.next()){
				values.add(rs.getString(1));
			}
		}
		catch(SQLException | ClassNotFoundException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());

		}
		return values;

	}
	/**
	 * This method get query and execute on Default connection
	 * @param query
	 * @return ResultSet
	 */
	public static ResultSet exeQuery(String query)
	{
		System.out.println( "Query passed for execution: " +query);
		Statement stmt;
		ResultSet rs = null;
		try
		{
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs =stmt.executeQuery(query);
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());

		}
		return rs;

	}

	/**
	 * his method connects with Management Database
	 * Get query and execute
	 *   -where Key Value is 'ManagementDatabase' in properties file
	 * @param query
	 * @return ResultSet
	 */
	public ResultSet  SQLserverConnection(String query)
	{
		ResultSet rs=null;
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofManagement);
			conn= DriverManager.getConnection(conStrofManagement,DbUserName,DbPassword);
			PreparedStatement ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		return rs;
	}
	/**
	 * his method connects with CDR Database
	 * Get query and execute it on CDR database 
	 *   -where Key Value is 'CDRDatabase' in properties file
	 * @param query
	 * @return ResultSet
	 */
	public static ResultSet exeQueryCDR(String query)
	{
		ResultSet rs=null;
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofcdr);
			conn= DriverManager.getConnection(conStrofcdr,DbUserName,DbPassword);
			PreparedStatement ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
		}

		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());

		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}

		return rs;
	}
	/**
	 * his method connects with WebDatabase Database
	 * Get query and execute it on WebDatabase database 
	 *       -where Key Value is 'WebDatabase' in properties file
	 * @param query
	 * @return ResultSet
	 */
	public static ResultSet exeQueryWeb(String query)
	{
		ResultSet rs=null;
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofWebdemo);
			conn= DriverManager.getConnection(conStrofWebdemo,DbUserName,DbPassword);
			PreparedStatement ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}

		return rs;
	}

	/**
	 * his method connects with WebDatabase Database
	 * Get query and execute it on WebDatabase database 
	 *       -where Key Value is 'WebDatabase' in properties file
	 * @param query
	 * @return ResultSet
	 */
	public ResultSet  SQLserverConnection1(String query)
	{
		ResultSet rs=null;
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofWebdemo);
			conn= DriverManager.getConnection(conStrofWebdemo,DbUserName,DbPassword);
			PreparedStatement ps = conn.prepareStatement(query);
			rs=ps.executeQuery();
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		return rs;
	}
	/**
	 * This method connects with Web Database
	 * Get query and execute it on WebDatabase
	 *   -where Key Value is 'WebDatabase' in properties file
	 * @return List of First result present in resultet
	 */
	public List<String> SQLserverConnection2(String query)
	{
		List <String> values=new ArrayList<String>();
		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofWebdemo);
			conn= DriverManager.getConnection(conStrofWebdemo,DbUserName,DbPassword);
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				values.add(rs.getString(1));
			}
		}

		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());

		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}

		return values;
	}

	/**
	 * his method connects with WebDatabase Database
	 * Get query and execute it on WebDatabase database 
	 * @param query
	 */
	public void  SQLserverConnection3(String query)
	{

		try
		{
			Class.forName(DbDriver);
			Setup.log.debug(conStrofWebdemo);
			conn= DriverManager.getConnection(conStrofWebdemo,DbUserName,DbPassword);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException e)
		{
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
		catch (ClassNotFoundException e) {
			Setup.log.debug(e);
			Setup.log.fatal(e.toString());
		}
	}

}
