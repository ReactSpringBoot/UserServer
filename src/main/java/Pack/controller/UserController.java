package Pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Pack.dto.UserDTO;
import Pack.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("signUp")
	public boolean signUpPost(@RequestBody UserDTO dto) {	
		System.out.println(dto.getName());
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		return service.signUp(dto);
	}
	
	@PostMapping("/login")
	public Object login(@RequestBody UserDTO dto) {
		System.out.println("login");
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		UserDTO user = service.login(dto);
		
		return user;
	}
}
