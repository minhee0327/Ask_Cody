package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.FreeBoardDao;
import service.FreeBoardService;
import service.FreeBoardServiceImpl;
import vo.BD_ImgVO;
import vo.BoardVO;

@WebServlet("/write.do")
@MultipartConfig(maxFileSize = 1024*1024*5)
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/write.do 처리\n");
        
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if(id ==  null) {
        	System.out.println(id);
        	getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);
        
        BoardVO vo = new BoardVO();
        
        vo.setUser_id(id);
//        vo.setUser_id("daniel");
        vo.setTitle(request.getParameter("title"));
        
        vo.setContent(request.getParameter("content"));
        vo.setPost_date(new java.sql.Date(new Date().getTime()));
        vo.setCount(0);
        
        try {
            service.writeBoard(vo);
            response.sendRedirect("listBoard.do");
         }catch (Exception e) {
         	request.setAttribute("exception", new Exception("등록 데이터  확인후 다시 등록하세요"));
         	getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
         }
	}
}
