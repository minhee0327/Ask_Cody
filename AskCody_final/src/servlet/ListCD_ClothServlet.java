package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CD_ClothDAO;
import service.CD_ClothService;
import service.CD_ClothServiceImpl;
import vo.CD_ClothVO;

@WebServlet("/listcoordi.do")
public class ListCD_ClothServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listcoordi.do 요청 처리 ");
		
		CD_ClothDAO dao = new CD_ClothDAO();
		CD_ClothService service = new CD_ClothServiceImpl(dao);
		
		int coordi_id= Integer.parseInt(request.getParameter("coordi_id"));
		List <CD_ClothVO> list = service.loadCoordi(coordi_id);
		
		
		request.setAttribute("loadcoordibook", list);
		String view = "/coordi_list.jsp";
			
		getServletContext().getRequestDispatcher(view).forward(request, response);
			
		}
	}
