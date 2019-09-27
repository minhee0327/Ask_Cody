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

@WebServlet("/go_board_modify.do")
public class GoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/go_board_modify.do 처리");
        
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if(login ==  null) {
        	request.setAttribute("hidden", "hidden");
        }
        
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);

        try {
			List<BoardVO> list = service.post(Integer.parseInt(request.getParameter("post_id")));
			int postid = list.get(0).getPost_id();
			String title = list.get(0).getTitle();
			String content = list.get(0).getContent();
			int count = list.get(0).getCount();
			
			request.setAttribute("postid", postid);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("count", count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        String view = "/board_modify.jsp";
        
        getServletContext().getRequestDispatcher(view).forward(request, response);
        
	}
}
