package service;

import java.util.List;

import vo.CoordiVO;

public interface CoordiService {
	
	List<CoordiVO> loadCoordi(String user_id);
	int addCoordi(CoordiVO vo);
	int retcodyId() throws Exception;
}
