package be.bxl.icc.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.bxl.icc.reservation.model.User;
import be.bxl.icc.reservation.model.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/users/{id}")
	public String index(Model model,@PathVariable("id") String id) {
		User user = userService.getUser(id);
		
		model.addAttribute("user", user);
		model.addAttribute("title", "Page de connexion");
		return "user/index";
		
		
	}

}
