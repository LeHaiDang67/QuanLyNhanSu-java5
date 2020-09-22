package edu.poly.fpt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.fpt.models.User;
import edu.poly.fpt.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String list(ModelMap model) {

		model.addAttribute("users", userService.findAll());
		return "users/list";
	}

	@GetMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("user", new User());
		return "users/addOrEdit";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, User user) {
		userService.save(user);
		model.addAttribute("user", user);
		return list(model);
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") Integer id) {
		userService.deleteById(id);
		return list(model);
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id, ModelMap model) {

		Optional<User> a = userService.findById(id);
		model.addAttribute("user", a);
		return "users/addOrEdit";
	}

	@RequestMapping("/find")
	public String find(ModelMap model, @RequestParam(defaultValue = "") String username) {
		List<User> list = userService.findByUsernameLikeOrderByUsername(username);
		model.addAttribute("users", list);
		return "users/list";

	}

	@GetMapping("/login")
	public String showLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return "users/login";
	}

	@PostMapping("/login")
	public String Login(ModelMap model, User user) {
		User a = userService.findByUsername(user.getUsername());
		if (a.getPassword().equals(user.getPassword())) {
			
			return list(model);
		}

		 return "users/login";
		

	}

}
