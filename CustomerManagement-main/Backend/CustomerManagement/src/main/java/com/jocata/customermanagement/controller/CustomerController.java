package com.jocata.customermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.customermanagement.model.CustomerData;
import com.jocata.customermanagement.model.FetchCustomerDetails;
import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@PostMapping("/login")
	public @ResponseBody Map<String, String> loginDetails(@RequestBody Login login) throws Exception {
		String resp = customerService.checkLoginCredentials(login);
		Map<String, String> response = new HashMap<>();
		response.put("message", resp);
		return response;
	}

	@GetMapping(value = "/fetchCustomerDetails")
	public List<FetchCustomerDetails> fetchCustomerDetails() {
		return customerService.getAllCustomersDetails();
	}

	@PostMapping("/addcustomer")
	public @ResponseBody Map<String, String> addCustomer(@RequestBody CustomerData customer) {

		Map<String, String> response = new HashMap<String, String>();
		String resp = "";
		boolean value = customerService.aadharExists(customer);
		if (value) {
			System.out.println("*************************************");
			System.out.println("Already Data Exist!!!!");
			System.out.println("*************************************");
			resp = "exists";

		} else {
			customerService.addCustomer(customer);
			resp = "success";
		}
		response.put("message", resp);

		return response;
	}

}
