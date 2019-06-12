package com.ictcg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ictcg.model.Customer;
import com.ictcg.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService =  customerService;
	}
	
	@GetMapping("/list")
	public String findAll(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customer-list";
	}
	
	@GetMapping("/customerAddForm")
	public String update(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@GetMapping("/customerUpdateForm")
	public String update(@RequestParam Integer customerId, Model model) {
		
		model.addAttribute("customer", customerService.findById(customerId));
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String update(@ModelAttribute("customer") Customer customer, Model model) {
		
		customerService.save(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer customerId, Model model) {
		
		Customer customer = customerService.findById(customerId);
		customerService.delete(customer);
		model.addAttribute("customer", customer);
		
		return "redirect:/customer/list";
	}
}
