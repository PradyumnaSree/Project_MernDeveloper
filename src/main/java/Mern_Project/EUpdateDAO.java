package Mern_Project;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EUpdateDAO 
{
	public int k;
	public CreateAdminBean ab;
	Connection con=DBConnection.getCon();
	public int update(CreateAdminBean ab)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("UPDATE T_EMPLOYEE SET F_IMAGE=?, F_EMAIL=?, F_MOBILE=?, F_DESIGNATION=?, F_GENDER=?, F_COURSE=? WHERE F_NAME=?");
			ps.setBinaryStream(1, ab.getF_IMAGE());
			ps.setString(2, ab.getF_EMAIL());
			ps.setLong(3, ab.getF_MOBILE());
			ps.setString(4, ab.getF_DESIGNATION());
			ps.setString(5, ab.getF_GENDER());
			ps.setString(6, ab.getF_COURSE());
			ps.setString(7, ab.getF_NAME());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	public CreateAdminBean retrieve(String name)
	{
		try
		{
			PreparedStatement ps=con.prepareStatement("SELECT * FROM T_EMPLOYEE WHERE F_NAME=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
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
}
