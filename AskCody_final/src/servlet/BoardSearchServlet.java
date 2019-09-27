package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeBoardDao;
import service.FreeBoardService;
import service.FreeBoardServiceImpl;
import vo.BoardVO;

@WebServlet("/board_search.do")
public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/board_search.do 처리");
        
        String condition = request.getParameter("condition");
        String keyword = request.getParameter("keyword");
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);
        
        int line_num = 5;
        
        try {
			List<BoardVO> list = service.SearchList(condition, keyword);
			request.setAttribute("boardlist", list);

			int list_all = service.count_search_move(condition, keyword);
			int list_num;
			if(list_all%line_num == 0) {
				list_num = (int)Math.ceil(list_all/line_num);
			} else {
				list_num = (int)Math.ceil(list_all/line_num)+1;
			}

			request.setAttribute("list_num", list_num);
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
        } catch (Exception e) {
			e.printStackTrace();
		}
        String view ="/freeboard.jsp";

        getServletContext().getRequestDispatcher(view).forward(request, response);
	}
}
