package Mern_Project;

import java.io.InputStream;
import java.io.Serializable;

public class CreateAdminBean implements Serializable
{
	private InputStream F_IMAGE;
	private int F_ID;
	private String F_NAME, F_EMAIL, F_DESIGNATION, F_GENDER,F_COURSE,F_CREATEDATE;
	private long F_MOBILE;
	

	public InputStream getF_IMAGE() {
		return F_IMAGE;
	}
	public void setF_IMAGE(InputStream f_IMAGE) {
		F_IMAGE = f_IMAGE;
	}
	public int getF_ID() {
		return F_ID;
	}
	public void setF_ID(int f_ID) {
		F_ID = f_ID;
	}
	public String getF_NAME() {
		return F_NAME;
	}
	public void setF_NAME(String f_NAME) {
		F_NAME = f_NAME;
	}
	public String getF_EMAIL() {
		return F_EMAIL;
	}
	public void setF_EMAIL(String f_EMAIL) {
		F_EMAIL = f_EMAIL;
	}
	public String getF_DESIGNATION() {
		return F_DESIGNATION;
	}
	public void setF_DESIGNATION(String f_DESIGNATION) {
		F_DESIGNATION = f_DESIGNATION;
	}
	public String getF_GENDER() {
		return F_GENDER;
	}
	public void setF_GENDER(String f_GENDER) {
		F_GENDER = f_GENDER;
	}
	public String getF_COURSE() {
		return F_COURSE;
	}
	public void setF_COURSE(String f_COURSE) {
		F_COURSE = f_COURSE;
	}
	public String getF_CREATEDATE() {
		return F_CREATEDATE;
	}
	public void setF_CREATEDATE(String f_CREATEDATE) {
		F_CREATEDATE = f_CREATEDATE;
	}
	public long getF_MOBILE() {
		return F_MOBILE;
	}
	public void setF_MOBILE(long f_MOBILE) {
		F_MOBILE = f_MOBILE;
	}
	@Override
	public String toString() {
		return "F_IMAGE=" + F_IMAGE + ", F_ID=" + F_ID + ", F_NAME=" + F_NAME + ", F_EMAIL=" + F_EMAIL
				+ ", F_DESIGNATION=" + F_DESIGNATION + ", F_GENDER=" + F_GENDER + ", F_COURSE=" + F_COURSE
				+ ", F_CREATEDATE=" + F_CREATEDATE + ", F_MOBILE=" + F_MOBILE ;
	}
	
	
}
