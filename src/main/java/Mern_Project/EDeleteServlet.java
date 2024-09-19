package Mern_Project;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
@SuppressWarnings("serial")
public class EDeleteServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		int k,klb;
		CreateAdminBean ab=new EDeleteDAO().retrieve(req.getParameter("F_NAME"), req.getParameter("F_EMAIL"));
		System.out.println("ab: "+ab);
		if(ab!=null)
		{
			k= new EDeleteDAO().delete(ab);
			System.out.println("k: "+k);
			if(k>0)
			{
				req.setAttribute("msg", "Deleted successfully");
				req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
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
