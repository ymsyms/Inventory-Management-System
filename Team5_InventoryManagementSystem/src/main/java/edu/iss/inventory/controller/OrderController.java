package edu.iss.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	/**
	 * USER CRUD OPERATIONS
	 *
	 * @return
	 */

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newOrder() {
		ModelAndView mav = new ModelAndView("order");
		mav.addObject("productList", pService.findInsufficientProduct());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("order");
		if(input productId is valid) {

		}
		else {
			// go to orderPage and load hashmap
		}
		if(got session got order hashmap) {
			//check if the partId is valid
			//load data from hashmap
		}
		else {
			//load the data from productService
		}
		mav.addObject("product", pService.findProductById());
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id) {

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws UserNotFound {

	}
}
