package edu.iss.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.iss.inventory.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	UserService userService;

}
