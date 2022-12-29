package Pack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Pack.dto.UserDTO;
import Pack.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/signUp")
	public boolean signUpPost(@RequestBody UserDTO dto) {	
		System.out.println(dto.getName());
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		return service.signUp(dto);
	}
	
	@PostMapping("/login")
	public Object login(@RequestBody UserDTO dto, HttpServletRequest request) {
		
		System.out.println("login");		
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		
		UserDTO user = service.login(dto, request);
		
		return user;
	}
	
	@GetMapping("/getSession")
	public Object getSession(HttpServletRequest request) {
		
		System.out.println("getSession");	
		
		UserDTO user = service.getSession(request);
		
		return user;
	}
	
	@PostMapping("/logout")
	public void logout(HttpServletRequest request) {
		
		System.out.println("logout");	
		
		service.logout(request);
		
	}
}
