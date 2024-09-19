package Mern_Project;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/retrieve")
public class ERetriveAllServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		ERetrieveAllDAO er=new ERetrieveAllDAO();
		List<CreateAdminBean> list = er.retrieveAll();
//		System.out.println(list);
		if(list!=null)
		{
			req.setAttribute("list", list);
			req.setAttribute("msg", "Retrieved successfully.....<br>");
			req.getRequestDispatcher("RetrieveAll.jsp").forward(req, res);
		}
	}
}
