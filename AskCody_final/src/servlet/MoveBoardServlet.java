package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FreeBoardDao;
import service.FreeBoardService;
import service.FreeBoardServiceImpl;
import vo.BoardVO;

@WebServlet("/moveboard.do")
public class MoveBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/moveboard.do 처리");
        
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if(login ==  null) {
        	request.setAttribute("hidden", "hidden");
        }
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);
        
        String condition = request.getParameter("condition");
        String keyword = request.getParameter("keyword");
        
        int line_num = 5;
        int board_num = Integer.parseInt(request.getParameter("board_num"));
        try {
        	List<BoardVO> list = null;
        	int list_all = 0;
        	if(condition.equals("")) {
        		list = service.moveList(board_num);
				
				list_all = service.count_move();
        	} else {
        		list = service.moveSearchList(board_num,condition,keyword);
				list_all = service.count_search_move(condition,keyword);
				request.setAttribute("condition", condition);
				request.setAttribute("keyword", keyword);
        	}
        	request.setAttribute("boardlist", list);
			int list_num;
			if(list_all%line_num == 0) {
				list_num = (int)Math.ceil(list_all/line_num);
			} else {
				list_num = (int)Math.ceil(list_all/line_num)+1;
			}

			request.setAttribute("list_num", list_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String view = "/freeboard.jsp";
        
        getServletContext().getRequestDispatcher(view).forward(request, response);
        
	}
}
