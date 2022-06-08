package be.bxl.icc.reservation.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bxl.icc.reservation.model.User;
import be.bxl.icc.reservation.model.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/register")
	
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		 model.addAttribute("title", "Page inscription");
		return "user/register"; 
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		user.setCreated_at(LocalDateTime.now());
		userService.addUser(user);
		return "user/register_success";
		
	}
	
	
	@GetMapping("/users/{id}")
	public String index(Model model,@PathVariable("id") String id) {
		User user = userService.getUser(id);
		
		model.addAttribute("user", user);
		model.addAttribute("title", "Page de connexion");
		return "user/index";
			
	}

}
