package Mern_Project;
import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/logout")
	public class LogOutServlet extends HttpServlet
	{
		protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
		{
			ServletContext sct=req.getServletContext();
			Cookie c[]=req.getCookies();
				sct.removeAttribute("lBean");
				c[0].setMaxAge(0);
				res.addCookie(c[0]);
				req.setAttribute("msg", "Logged Out Successfully.....<br>");
				req.getRequestDispatcher("logOut.jsp").forward(req, res);			
		}
		
}
