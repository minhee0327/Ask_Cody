package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoordiDAO;
import service.CoordiService;
import service.CoordiServiceImpl;
import vo.CoordiVO;

@WebServlet("/listcoordibook.do")
public class ListCoordiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listcoordibook.do 요청 처리 ");
		
		 HttpSession session = request.getSession();
	     String id = (String) session.getAttribute("id");
		
		CoordiDAO dao = new CoordiDAO();
		CoordiService service = new CoordiServiceImpl(dao);
		
		List<CoordiVO> list = service.loadCoordi(id);
		System.out.println("list ==> " + list);
		request.setAttribute("loadcoordibook", list);
		String view = "/selectcoordi.jsp";
		
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
	}

}
