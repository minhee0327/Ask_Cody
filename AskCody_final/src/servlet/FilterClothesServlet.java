package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/filterClothes.do")
public class FilterClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String cloth_type = request.getParameter("cloth_type");
		String cloth_color = request.getParameter("cloth_color");
		System.out.println(cloth_type+" : "+cloth_color);

		ClothesDAO_Oracle dao = new ClothesDAO_Oracle();
		ClothesService service = new ClothesService_Imp(dao);
		
		try {
			List<ClothesVO> list = null;
			
			if (cloth_type==null || cloth_color==null) {

				PrintWriter out = response.getWriter();
				out.println("<script> alert('please'); location.href='./finder.jsp'; </script>");
				out.println("<script> </script>");
				out.flush();
				return;
				
			} else if (cloth_type.equals("alltype") && !cloth_color.equals("allcolor")) {
				list = service.filteralltypeclothes(cloth_color);

			} else if (cloth_color.equals("allcolor") && !cloth_type.equals("alltype")){
				list = service.filterallcolorclothes(cloth_type);

			} else if (cloth_type.equals("alltype") && cloth_color.equals("allcolor")) {			
				list = service.allclothesList();		

			} else {
				list = service.filterclothes(cloth_type, cloth_color);				
			}
			
			System.out.println("listClothes"+list);
			System.out.println();
			request.setAttribute("filteredlist", list);
			String view = "/finder.jsp";
			
			getServletContext().getRequestDispatcher(view).forward(request, response);
			
		} catch (Exception e) {
			
		}
		
	}

}