package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.CD_ClothDAO;
import dao.CoordiDAO;
import service.CD_ClothService;
import service.CD_ClothServiceImpl;
import service.CoordiService;
import service.CoordiServiceImpl;
import vo.CD_ClothVO;
import vo.CoordiVO;

@WebServlet("/savecoordi.do")
public class SaveCoordiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		System.out.println("/savecoordi.do 요청 처리 ");
	
		  HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("id");
		
		CD_ClothDAO dao1 = new CD_ClothDAO();
		CD_ClothService service1 = new CD_ClothServiceImpl(dao1);
		CD_ClothVO vo1 = new CD_ClothVO();
		
		CoordiDAO dao = new CoordiDAO();
		CoordiService service = new CoordiServiceImpl(dao);
		CoordiVO vo = new CoordiVO();
		
		int list_num =Integer.parseInt(request.getParameter("list_num"));
		String[] list = request.getParameterValues("list[]");
		
		JSONObject json = new JSONObject();
		json.put("data", "success");
		
		PrintWriter out = response.getWriter();
		
			
		System.out.println("list_num => "+list_num);
		try {
			vo.setUser_id(id);
			service.addCoordi(vo);
			
			for(int i=0;i<list_num;i++) {
				System.out.println("이미지 저장");
				vo1.setCoordi_id(dao.retcodyId());
				vo1.setImage(list[i]);
				System.out.println("vo1" + vo1);
				service1.addCoordi(vo1);
			}
			
			
			out.print(json.toString());
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
		}
	}

}
