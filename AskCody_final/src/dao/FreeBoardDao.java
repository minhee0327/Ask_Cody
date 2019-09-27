package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import util.JDBCUtil;
import vo.BoardVO;

public class FreeBoardDao {
	final int line_num = 5;
	public List<BoardVO> boardList() throws Exception {
		String sql = "select * from (select rownum row#,post_id,user_name,title,post_date,count from " +
				"(select * from board b,users u where b.user_id=u.id) order by post_id desc) where row# between ? and ? ";

		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, 0*line_num+1);
			ps.setInt(2, 1*line_num);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setPost_id(rs.getInt("post_id"));
				vo.setUser_id(rs.getString("user_name"));
				vo.setTitle(rs.getString("title"));
				vo.setPost_date(rs.getDate("post_date"));
				vo.setCount(rs.getInt("count"));

				list.add(vo);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}
	
	public int count_move() throws Exception {
		
		String sql = "select * from board ";
		
		int count = 0;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				count++;

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return count;
	}
	public List<BoardVO> post(int post_id) throws Exception {
		String sql = "select * from board where post_id = ?";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, post_id);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setPost_id(rs.getInt("post_id"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setPost_date(rs.getDate("post_date"));
				vo.setCount(rs.getInt("count")+1);

				list.add(vo);

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		
		return list;
	}
	
	public int count(BoardVO vo) throws Exception {
		String sql = "update board set count = ? where post_id = ?";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, vo.getCount());
		ps.setInt(2, vo.getPost_id());
		
		result = ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}
	
	public List<BoardVO> moveList(int board_num) throws Exception {

		String sql = "select * from (select rownum row#,post_id,user_name,title,post_date,count from " +
				"(select * from board b,users u where b.user_id=u.id) order by post_id desc) where row# between ? and ? ";

		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, (board_num-1)*line_num+1);
			ps.setInt(2, (board_num)*line_num);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setPost_id(rs.getInt("post_id"));
				vo.setUser_id(rs.getString("user_name"));
				vo.setTitle(rs.getString("title"));
				vo.setPost_date(rs.getDate("post_date"));
				vo.setCount(rs.getInt("count"));

				list.add(vo);

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}
	
	public List<BoardVO> searchList(String condition, String keyword) throws Exception {
		String sql = "select * from (select rownum row#,post_id,user_name,title,post_date,count "+
				"from (select * from board b,users u where b.user_id=u.id and "+ condition +" like '%'||?||'%') " +
				"order by post_id desc) where row# between ? and ? ";

		
		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
	
			
			ps.setString(1, keyword);
			ps.setInt(2, 0*line_num+1);
			ps.setInt(3, 1*line_num);
			
			
			
			
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setPost_id(rs.getInt("post_id"));
				vo.setUser_id(rs.getString("user_name"));
				vo.setTitle(rs.getString("title"));
				vo.setPost_date(rs.getDate("post_date"));
				vo.setCount(rs.getInt("count"));

				list.add(vo);

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}

	public int writeBoard(BoardVO vo) throws Exception {
		
		String sql = "insert into board(post_id, user_id, title, content, post_date, count) "+
						"values((select nvl(max(post_id),0)+1 from board),?,?,?,?,?) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
		
			ps.setString(1, vo.getUser_id());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getContent());
			ps.setDate(4, vo.getPost_date());
			ps.setInt(5, vo.getCount());
			
			System.out.println(vo);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}

	public int deleteBoard(int post_id) throws Exception {
		
		String sql = "delete from board where post_id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, post_id);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}

	public int modifyBoard(BoardVO vo) throws Exception{
		
		String sql = "update board set title = ?,content = ?,post_date = ?,count = ? where post_id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getContent());
		ps.setDate(3, vo.getPost_date());
		ps.setInt(4, vo.getCount());
		ps.setInt(5, vo.getPost_id());
		
		result = ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}

	public List<BoardVO> moveSearchList(int board_num, String condition, String keyword) throws Exception {
		String sql = "select * from (select rownum row#,post_id,user_name,title,post_date,count from " +
				"(select * from board b,users u where b.user_id=u.id and "+condition+" like '%'||?||'%') order by post_id desc) where row# between ? and ? ";

		
		List<BoardVO> list = new ArrayList<BoardVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, keyword);
			ps.setInt(2, (board_num-1)*line_num+1);
			ps.setInt(3, (board_num)*line_num);

			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setPost_id(rs.getInt("post_id"));
				vo.setUser_id(rs.getString("user_name"));
				vo.setTitle(rs.getString("title"));
				vo.setPost_date(rs.getDate("post_date"));
				vo.setCount(rs.getInt("count"));

				list.add(vo);

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}

	public int count_search_move(String condition, String keyword) throws Exception {
		String sql = "select * from board b,users u where b.user_id=u.id and "+condition+" like '%'||?||'%' ";
		

		int count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, keyword);
			rs = ps.executeQuery();

			while (rs.next()) {
				count++;

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return count;
	}

}
