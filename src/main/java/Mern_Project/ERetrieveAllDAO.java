package Mern_Project;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ERetrieveAllDAO 
{
	public List<CreateAdminBean> ab=new ArrayList<CreateAdminBean>();
	public List<CreateAdminBean> retrieveAll() 
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM T_EMPLOYEE");
			ResultSet rs=ps.executeQuery();
			
				while(rs.next())
				{
					CreateAdminBean c=new CreateAdminBean();
					c.setF_ID(rs.getInt(1));
					Blob blob = rs.getBlob(2);
					InputStream binaryStream = blob.getBinaryStream();
					c.setF_IMAGE(binaryStream);
					c.setF_NAME(rs.getString(3));
					c.setF_EMAIL(rs.getString(4));
					c.setF_MOBILE(rs.getLong(5));
					c.setF_DESIGNATION(rs.getString(6));
					c.setF_GENDER(rs.getString(7));
					c.setF_COURSE(rs.getString(8));
					c.setF_CREATEDATE(rs.getString(9));
					ab.add(c);
				}
				System.out.println(ab);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}
}
