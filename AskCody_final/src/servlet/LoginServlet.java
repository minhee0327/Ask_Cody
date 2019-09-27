package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import dao.UsersDao_Oracle;
import service.UsersService;
import service.UsersServiceImpl;
import vo.UsersVO;

@WebServlet({"/login.do","/logout.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 if(session != null) {
			 session.invalidate();
		 }
		 response.sendRedirect("./index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		UsersDao dao = new UsersDao_Oracle();
		UsersService service = new UsersServiceImpl(dao);
		List<UsersVO> list = service.UsersList();

		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		for (UsersVO data : list) {
			if (id.equals(data.getId())) {
				String dbpw;
				UsersVO user = dao.getUsersRec2(id).get(0);
				dbpw = user.getPassword();
				if (password.equals(dbpw)) {
					HttpSession session = request.getSession();
					session.setAttribute("id",user.getId());
					session.setAttribute("user_name", user.getUser_name());
					session.setAttribute("role", user.getRole());
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
				} else {
					request.setAttribute("msg", "비밀번호가 틀렸습니다.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
			} 
		}
		request.setAttribute("msg", "아이디가 틀렸습니다.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}
}
