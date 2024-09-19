package Mern_Project;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EDeleteDAO 
{
	CreateAdminBean ab;
	int k;
	Connection con=DBConnection.getCon();
	public CreateAdminBean retrieve(String name, String eMail)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM T_EMPLOYEE WHERE F_NAME=? and F_EMAIL=?");
			ps.setString(1, name);
			ps.setString(2, eMail);
			ResultSet rs=ps.executeQuery();
			System.out.println("rs: "+rs);
			while(rs.next())
			{
				ab=new CreateAdminBean();
				ab.setF_ID(rs.getInt(1));
				Blob b=rs.getBlob(2);
				InputStream i=b.getBinaryStream();
				ab.setF_IMAGE(i);
				ab.setF_NAME(rs.getString(3));
				ab.setF_EMAIL(rs.getString(4));
				ab.setF_MOBILE(rs.getLong(5));
				ab.setF_DESIGNATION(rs.getString(6));
				ab.setF_GENDER(rs.getString(7));
				ab.setF_COURSE(rs.getString(8));
				ab.setF_CREATEDATE(rs.getString(9));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
	public int delete(CreateAdminBean ab)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("DELETE T_EMPLOYEE WHERE F_NAME=? and F_EMAIL=?");
			ps.setString(1, ab.getF_NAME());
			ps.setString(2, ab.getF_EMAIL());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
