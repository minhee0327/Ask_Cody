package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BoardVO;
import vo.CoordiVO;

public class CoordiDAO {
	public int saveCoordi(CoordiVO vo) {
		System.out.println("코디 저장 시작");
		String sql = "insert into coordi values((select nvl(max(coordi_id),0)+1 from coordi), " +
		"(select nvl(max(coordi_id),0)+1 from coordi), ? ,sysdate)";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			System.out.println(vo.getUser_id());
			ps.setString(1, vo.getUser_id());
			//실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			System.out.println("코디 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	
	public int retcodyId() throws Exception {
		String sql =  "select max(coordi_id) as coordi_id from coordi ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int codyid = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				codyid = rs.getInt("coordi_id");
				System.out.println("코디아이디"+codyid);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return codyid;
	}
	
	
	public List<CoordiVO> loadCoordi(String user_id) {
		System.out.println("Coordibook load 요청처리");
		String sql ="select * from coordi where user_id=? order by coordi_id ";
		
		List <CoordiVO> list = new ArrayList<CoordiVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅
			ps.setString(1, user_id);
			//실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while(rs.next()) {
				CoordiVO vo = new CoordiVO();
				vo.setCoordi_id(rs.getInt("coordi_id"));
				vo.setCoordi_name(rs.getString("coordi_name"));
				vo.setUser_id(rs.getString("user_id"));
				//vo.setCoordi_date(rs.getDate(4));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
		
	}
}
