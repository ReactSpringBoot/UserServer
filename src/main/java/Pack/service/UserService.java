package Pack.service;

import javax.servlet.http.HttpServletRequest;

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
	
	public UserDTO login(UserDTO dto, HttpServletRequest request) {
		UserDTO user = dao.login(dto);
		
		if ((user == null) || !(dto.getPw().equals(user.getPw()))) return null;
		
		user.setPw(null);
			
		request.getSession().setAttribute("id", user.getId());
		request.getSession().setAttribute("name", user.getName());
		request.getSession().setAttribute("userNo", user.getUserNo());
			
		return user;
	}
	
	public UserDTO getSession(HttpServletRequest request) {
		UserDTO user = new UserDTO();
		
		if ((request.getSession().getAttribute("userNo")) == null) return null;
		
		user.setId((String)request.getSession().getAttribute("id")); 
		user.setName((String)request.getSession().getAttribute("name")); 
		user.setUserNo((int)request.getSession().getAttribute("userNo")); 
		
		return user;
	}
	
	public void logout(HttpServletRequest request) {			
		request.getSession().invalidate();	
	}
}
