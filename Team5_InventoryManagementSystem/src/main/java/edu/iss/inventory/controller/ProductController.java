package edu.iss.inventory.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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

import edu.iss.inventory.model.Product;
import edu.iss.inventory.repository.ProductRepository;
import edu.iss.inventory.service.ProductService;
import edu.iss.inventory.service.ProductSupplierService;

@RequestMapping(value = "/admin/product")
@Controller
public class ProductController {

	@Resource
	ProductRepository prepo;

	@Autowired
	private ProductService pService;
	@Autowired
	private ProductSupplierService psService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage() {
		ModelAndView mav = new ModelAndView("product-new", "product", new Product());
		mav.addObject("productlist", pService.findAllProducts());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()){
			return new ModelAndView("product-new");
			}

		ModelAndView mav = new ModelAndView();
		String message = "New product " + product.getPartNo() + " was successfully created.";

		pService.createProduct(product);
		mav.setViewName("redirect:/admin/product/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage() {
		ModelAndView mav = new ModelAndView("product-list");
		ArrayList<Product> productList = (ArrayList<Product>) prepo.findAll();
		mav.addObject("productList", productList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("product-edit");
		Product product = pService.findProducts(id);
		mav.addObject("product", product);
		mav.addObject("productlist", pService.findAllProducts());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /* throws ProductNotFound */ {

		if (result.hasErrors())
			return new ModelAndView("product-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		String message = "Product was successfully updated.";

		pService.changeProduct(product);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable String id, final RedirectAttributes redirectAttributes)
	/* throws ProductNotFound */ {

		ModelAndView mav = new ModelAndView("redirect:/admin/product/list");
		Product product = pService.findProducts(id);
		pService.removeProduct(product);
		String message = "The product " + product.getPartNo() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;

	}
	@RequestMapping(value="/search/{product}",method=RequestMethod.GET)
	public ModelAndView searchProduct(@PathVariable Product product,final RedirectAttributes redirectAttributes)
	{
		ModelAndView mav= new ModelAndView("redirect:/admin/product/list");
		pService.searchProduct(product);
		return mav;
	}
	
	
}