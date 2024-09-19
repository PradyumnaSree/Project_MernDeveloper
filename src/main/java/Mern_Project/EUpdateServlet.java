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
@WebServlet("/update")
@SuppressWarnings("serial")
@MultipartConfig

public class EUpdateServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		int k=0;
		CreateAdminBean ab;
		
			ab=new CreateAdminBean();
			ab.setF_NAME(req.getParameter("F_NAME"));
			ab.setF_EMAIL(req.getParameter("F_EMAIL"));
			ab.setF_MOBILE(Long.parseLong(req.getParameter("F_MOBILE")));
			ab.setF_DESIGNATION(req.getParameter("F_DESIGNATION"));
			ab.setF_GENDER(req.getParameter("F_GENDER"));
			ab.setF_COURSE(req.getParameter("F_COURSE"));
			Part filePart = req.getPart("F_IMAGE"); 
//			System.out.println(filePart.getName());			
			if (filePart != null) 
			{	
			    InputStream inputStream = filePart.getInputStream();   
			    ab.setF_IMAGE(inputStream);
			}
			ab=new EUpdateDAO().retrieve(req.getParameter("F_NAME"));
			System.out.println("BEAN: "+ab);
			if(ab!=null)
			{
				k= new EUpdateDAO().update(ab);
				System.out.println("K value: "+k);
				if(k>0)
				{
					req.setAttribute("msg", "Updated successfully");
					req.getRequestDispatcher("UpdateSuccess.jsp").forward(req, res);
				}
				else
				{
					req.setAttribute("msg", "Not Updated successfully");
					req.getRequestDispatcher("Msg.jsp").forward(req, res);
				}
			}
			else
			{
				req.setAttribute("msg", "Invalid Credentials");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
		
	}
}
