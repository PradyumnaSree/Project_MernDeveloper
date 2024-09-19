package Mern_Project;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con;
	private DBConnection() {}
	static 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(DBInfo.dbUrl,DBInfo.dbUName,DBInfo.dbPWord);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}
}

