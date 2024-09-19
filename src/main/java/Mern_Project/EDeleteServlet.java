package Mern_Project;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class EDeleteServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		int k,klb;
		CreateAdminBean ab=new EDeleteDAO().retrieve(req.getParameter("F_NAME"), req.getParameter("F_EMAIL"));
		LoginBean lb=new EDeleteDAO().retrieveLB(req.getParameter("F_NAME"));
		if(ab!=null && lb!=null) 
		{
			k= new EDeleteDAO().delete(ab);
			klb= new EDeleteDAO().deleteLB(lb);
			if(k>0 && klb>0)
			{
				req.setAttribute("msg", "Deleted successfully");
				req.getRequestDispatcher("DeleteSuccess.jsp").forward(req, res);
			}
			else
			{
				req.setAttribute("msg", "Deletion is not successful");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
		}
		else
		{
			req.setAttribute("msg", "Invalid credentials");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
