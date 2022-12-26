package Pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.dao.UserDao;
import Pack.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public boolean signUp(UserDTO dto) {
		return dao.signUp(dto);
	}
	
	public UserDTO login(UserDTO dto) {
		UserDTO user = dao.login(dto);
		
		if ((user == null) || !(dto.getPw().equals(user.getPw()))) return null;
			
		return user;
	}
}
