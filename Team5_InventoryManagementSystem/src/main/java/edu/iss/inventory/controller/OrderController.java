package edu.iss.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping(value = "/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService oService;

	@Autowired
	private ProductService pService;
	
	@Autowired
	private ProductValidator pValidator;

	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newOrder(HttpSession session) {

		//get insufficient product list
		List<Product> plist = pService.findInsufficientProduct();
		
		//add insufficient product list to session hashmap
		oService.addProductListToHashmap(plist, session);
		
		//return "order.jsp"
		return new ModelAndView("order");
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newOrder(HttpSession session) {

		//get insufficient product list
		List<Product> plist = pService.findInsufficientProduct();
		
		//add insufficient product list to session hashmap
		oService.addProductListToHashmap(plist, session);
		
		//return "order.jsp"
		return new ModelAndView("order");
	}

}
