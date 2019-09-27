package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CD_ClothDAO;
import service.CD_ClothService;
import service.CD_ClothServiceImpl;
import vo.SuggestionVO;

@WebServlet("/makecoordi.do")
public class MakeCoordiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/makecoordi.do 요청 처리 ");
		
		HttpSession session = request.getSession();
	        String id = (String) session.getAttribute("id");
	        System.out.println(id);
	        if(id ==  null) {
	        	System.out.println(id);
	        	getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	            return;
	    }
		
		CD_ClothDAO dao = new CD_ClothDAO();
		CD_ClothService service = new CD_ClothServiceImpl(dao);
		List <SuggestionVO> list = service.loadSuggestion();
		System.out.println(list);
		
		request.setAttribute("suggestion", list);
		String view = "/coordi_test2.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		
	}
}
