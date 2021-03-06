package lv.venta.project.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.project.models.Roles;
import lv.venta.project.models.User;
import lv.venta.project.repos.IUserRepo;

@Controller
public class RegistrationController {
	@Autowired
	private IUserRepo userRepo;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration-page";
	}
	
	@PostMapping("/registration")
	public String addUser(User user, Map<String, Object> model) {
		User userFromDb = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userFromDb != null) {
			//model.put("message", "User exists!");
			return "registration-page";
		}
		user.setActive(true);
		user.setRole(Collections.singleton(Roles.USER));
		userRepo.save(user);
		
		return "redirect:/login";
	}
}
