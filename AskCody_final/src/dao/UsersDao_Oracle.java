package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import util.JDBCUtil;

import vo.UsersVO;

public class UsersDao_Oracle extends UsersDao {

	public int insertusers(UsersVO vo) throws Exception {

		String sql = "INSERT INTO Users(id, password, user_name, birthday, email, role) VALUES (?,?,?,?,?,?) ";
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getUser_name());
			ps.setDate(4, vo.getBirthday());
			System.out.println(vo.getEmail());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getRole());
			result = ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int deleteUsers(UsersVO vo) {
		String sql = "delete* from users";

		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getUser_name());
			ps.setDate(4, vo.getBirthday());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getRole());

			result = ps.executeUpdate();
			// 실행 및 결과값 핸들링

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;

	}

	public int updateUsers(UsersVO vo) {
		String sql = "update users set password = ? where id = ?";
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;

	}

	public List<UsersVO> getUsersRec() {
		String sql = "select id from users";

		List<UsersVO> list = new ArrayList<UsersVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				UsersVO vo = new UsersVO();
				vo.setId(rs.getString("id"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return list;

	}

	public List<UsersVO> getUsersRec2(String id) {
		String sql = "select * from users where id =? ";

		List<UsersVO> list = new ArrayList<UsersVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				UsersVO vo = new UsersVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setUser_name(rs.getString("User_name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setRole(rs.getString("role"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return list;

	}

	public  String idcheck(String id) {
		String sql = "select * from users where id= ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString (1, id);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					map.put("id", (rs.getString("id")));
				}
		} catch (Exception e) {
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return JSONObject.toJSONString(map);
		
	 }
}