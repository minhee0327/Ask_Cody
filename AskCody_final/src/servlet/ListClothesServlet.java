package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClothesDAO_Oracle;
import service.ClothesService;
import service.ClothesService_Imp;
import vo.ClothesVO;


@WebServlet("/listClothes.do")
public class ListClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");		
		
		System.out.println("/listClothes.do 요청 처리");
		
		ClothesDAO_Oracle dao = new ClothesDAO_Oracle();
		ClothesService service = new ClothesService_Imp(dao);
		
		List<ClothesVO> list = service.allclothesList();
		
		System.out.println("listClothes"+list);
		request.setAttribute("clotheslist", list);
		String view = "/choice.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		
	}

}
