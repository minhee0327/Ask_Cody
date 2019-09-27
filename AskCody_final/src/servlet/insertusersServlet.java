package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import dao.UsersDao_Oracle;
import service.UsersService;
import service.UsersServiceImpl;
import vo.UsersVO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/insertusers.do")

public class insertusersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");	
		
		
		UsersDao dao = new UsersDao_Oracle();
		UsersService service = new UsersServiceImpl(dao);
		
			
			UsersVO vo = new UsersVO();
			vo.setId(request.getParameter("id"));
			vo.setPassword(request.getParameter("password"));
			vo.setUser_name(request.getParameter("user_name"));
			
			String oldstring = request.getParameter("birthday");
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
				java.sql.Date sql = new java.sql.Date(date.getTime());
				//System.out.println(sql);
				vo.setBirthday(sql);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			vo.setEmail(request.getParameter("email"));
			System.out.println("email"+vo.getEmail());
			vo.setRole(request.getParameter("role"));
			
			try {
				service.insertuser(vo);
				response.sendRedirect("login.jsp"); 
				} catch (Exception e) {
				
				request.setAttribute("exception", e);
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
	}

}
	
