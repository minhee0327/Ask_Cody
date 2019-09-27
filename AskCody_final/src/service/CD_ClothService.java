package service;

import java.util.List;

import vo.CD_ClothVO;
import vo.SuggestionVO;

public interface CD_ClothService {
	
	List <CD_ClothVO> loadCoordi(int coordi_id);
	int addCoordi(CD_ClothVO vo);
	int deleteCoordi(int coordi_id);
	List<SuggestionVO> loadSuggestion(); 
}
