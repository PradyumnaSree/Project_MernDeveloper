package Mern_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
	public LoginBean ab;
	public LoginBean login(String F_USERNAME,String F_PWORD)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM T_LOGIN WHERE F_USERNAME=? AND F_PWORD=?");
			ps.setString(1, F_USERNAME);
			ps.setString(2, F_PWORD);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ab=new LoginBean();
				ab.setF_SNO(rs.getInt(1));
				ab.setF_USERNAME(rs.getString(2));
				ab.setF_PWORD(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
}
