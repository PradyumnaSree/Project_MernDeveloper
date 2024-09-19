package Mern_Project;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/create")
@SuppressWarnings("serial")
@MultipartConfig
public class EDetailsServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		CreateAdminBean ab=new CreateAdminBean();
		ab.setF_NAME(req.getParameter("F_NAME"));
		ab.setF_EMAIL(req.getParameter("F_EMAIL"));
		ab.setF_MOBILE(Long.parseLong(req.getParameter("F_MOBILE")));
		ab.setF_DESIGNATION(req.getParameter("F_DESIGNATION"));
		ab.setF_GENDER(req.getParameter("F_GENDER"));
//		System.out.println(req.getParameter("F_GENDER")+"...........");
		ab.setF_COURSE(req.getParameter("F_COURSE"));
		Part filePart = req.getPart("F_IMAGE"); 
//		System.out.println(filePart.getName());
		
		if (filePart != null) 
		{
			
		    InputStream inputStream = filePart.getInputStream();
		    ab.setF_IMAGE(inputStream);
		}
		int k=new EDetailsDAO().insert(ab);
		if(k>0)
		{
			
			req.setAttribute("msg", "Inserted Successfully......<br>");
			req.getRequestDispatcher("EDetailsSuccess.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Not inserted successfully.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
