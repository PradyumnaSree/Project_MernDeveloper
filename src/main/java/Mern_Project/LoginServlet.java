package Mern_Project;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/log")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
			String uName=req.getParameter("F_USERNAME");
			String uPWord=req.getParameter("F_PWORD");
			LoginBean ab= new LoginDAO().login(uName, uPWord);
			if(ab==null)
			{
				req.setAttribute("msg", "Given Credentials are not valid <br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				ServletContext sct=req.getServletContext();
				sct.setAttribute("lBean", ab);
//				Cookie ck=new Cookie("uName",ab.getF_USERNAME());
//				res.addCookie(ck);
				req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
