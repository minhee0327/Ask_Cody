package service;

import java.util.List;


import vo.UsersVO;

public interface UsersService {
	
	List<UsersVO>UsersList();
	List<UsersVO>UsersList2(String id);
	int deleteusers(UsersVO vo);
	int updateusers(UsersVO vo);
	int insertuser(UsersVO vo) throws Exception;
	String idcheck(String id);

	
	
}
