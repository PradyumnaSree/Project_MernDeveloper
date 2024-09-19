package Mern_Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class EDetailsDAO 
{
	public static int count=1;
	public int k;
	public LocalDate date;
	public int insert(CreateAdminBean ab)
	{
		System.out.println(ab);
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("INSERT INTO T_EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, count++);
			ps.setBinaryStream(2, ab.getF_IMAGE());
			ps.setString(3, ab.getF_NAME());
			ps.setString(4, ab.getF_EMAIL());
			ps.setLong(5, ab.getF_MOBILE());
			ps.setString(6, ab.getF_DESIGNATION());
			ps.setString(7, ab.getF_GENDER());
			ps.setString(8, ab.getF_COURSE());
			Date d=Date.valueOf(LocalDate.now());
			ps.setDate(9, d);
			k=ps.executeUpdate();
//			Connection con=DBConnection.getCon();
//			PreparedStatement ps=con.prepareStatement("INSERT INTO demo1 VALUES(?,?)");
////			ps.setString(1, ab.getF_NAME());
////			ps.setString(2, ab.getF_EMAIL());
////			ps.setLong(3, ab.getF_MOBILE());
////			ps.setString(4, ab.getF_DESIGNATION());
////			ps.setString(5, ab.getF_GENDER());
////			ps.setString(6, ab.getF_COURSE());
//			ps.setInt(1, 100);
//			ps.setBlob(2, ab.getF_IMAGE());
//			System.out.println("EDetailsDAO.insert()");
//			k=ps.executeUpdate();
//			System.out.println(k);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
