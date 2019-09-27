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

@WebServlet("/post.do")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8"); 
        
        System.out.println("/post.do 처리");
        
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");
        if(login ==  null) {
        	request.setAttribute("hidden", "hidden");
        }
        
        FreeBoardDao dao = new FreeBoardDao();
        FreeBoardService service= new FreeBoardServiceImpl(dao);

        try {
			List<BoardVO> list = service.post(Integer.parseInt(request.getParameter("post_id")));
			BoardVO vo = list.get(0);
			
			int postid = vo.getPost_id();
			String title = vo.getTitle();
			String content = vo.getContent();
			int count = vo.getCount();
			String user_id = vo.getUser_id();
			
			vo.setCount(count);
			request.setAttribute("postid", postid);
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("user_id", user_id);

			service.count(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String view = "/post.jsp";
        
        getServletContext().getRequestDispatcher(view).forward(request, response);
        
	}
}
