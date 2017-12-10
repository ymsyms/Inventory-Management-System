package edu.iss.inventory.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.inventory.model.Product;

@RequestMapping(value="/transaction")
@Controller
public class TransactionController {
	
//	@Autowired
//	private TransactionService tService;
//	@Autowired
//	private TransactionValidator tValidator;
//	
//	@InitBinder("transaction")
//	private void initTransactionBinder(WebDataBinder binder) {
//		binder.addValidators(tValidator);
//	}
//	
//	@RequestMapping(value = "/usageSummary")
//	public ModelAndView openUsageSummary() {
//		ModelAndView mav = new ModelAndView("usage-summary");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/transHistory")
//	public ModelAndView openTransHistory() {
//		ModelAndView mav = new ModelAndView("transaction-history");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/transHistoryQuery")
//	public void transHistoryQuery() {
//		tService.queryTransHistory();
//	}
//	
//	@RequestMapping(value = "/submitUsage")
//	public void submitUsage() {
//		tService.submitTransaction();
//	}
//	
//	@RequestMapping(value = "/cartAdd")
//	public void addItem(HttpRequest request, HttpSession session)  {
//		tService.addItem(request, session);
//	}
//	
//	@RequestMapping(value = "/cartRemove")
//	public void removeItem(HttpRequest request, HttpSession session) {
//		tService.removeItem(request, session);
//	}
//	
//	@RequestMapping(value = "/cartUpdate")
//	public void updateItem(HttpRequest request, HttpSession session) {
//		tService.updateItem(request, session);
//	}
//	
//	@RequestMapping(value = "/cartClear")
//	public void clearCart(HttpRequest request, HttpSession session) {
//		tService.clearCart(request, session);
//	}
	
}
