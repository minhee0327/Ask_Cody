package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDao;
import service.FreeBoardService;
import service.FreeBoardServiceImpl;
import vo.BoardVO;

@WebServlet("/board_delete.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/board_modify.do 처리\n");
        
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);
        
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        try {
            service.deleteBoard(post_id);
            response.sendRedirect("listBoard.do");
         }catch (Exception e) {
         	request.setAttribute("exception", new Exception("등록 데이터  확인후 다시 등록하세요"));
         	getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
         }
	}

}
