package com.jocata.customermanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.customermanagement.entity.AccountLookup;
import com.jocata.customermanagement.model.AccountDetails;
import com.jocata.customermanagement.model.CustomerAddressPojo;
import com.jocata.customermanagement.model.CustomerData;
import com.jocata.customermanagement.model.CustomerDetailsPojo;
import com.jocata.customermanagement.model.CustomerNomineePojo;
import com.jocata.customermanagement.model.CustomerOccupationPojo;
import com.jocata.customermanagement.model.FetchCustomerDetails;
import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	// public CustomerDetails customerDetails;

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

	/*
	 * @PostMapping("/addcustomer") public @ResponseBody Map<String, String>
	 * addCustomer(@RequestBody CustomerData customer) {
	 * 
	 * Map<String, String> response = new HashMap<String, String>(); String resp =
	 * ""; boolean value = customerService.aadharExists(customer); if (value) {
	 * System.out.println("*************************************");
	 * System.out.println("Already Data Exist!!!!");
	 * System.out.println("*************************************"); resp = "exists";
	 * 
	 * } else { customerService.addCustomer(customer); resp = "success"; }
	 * response.put("message", resp);
	 * 
	 * return response; }
	 */
    
	@GetMapping("/getalldetails/{custId}")
	public @ResponseBody CustomerData getAllDetails(@PathVariable Integer custId) {

		// System.out.println(aadharNumber);
		return customerService.getAllCustomerDetails(custId);
	}

	@PostMapping("/addcustomerdetails")
	public @ResponseBody Map<String, Integer> addCustomerDetails(@RequestBody CustomerDetailsPojo customerDetailsPojo) {

		Map<String, Integer> response = new HashMap<>();

		boolean value = customerService.aadharExists(customerDetailsPojo);
		if (value) {
			System.out.println("*************************************");
			System.out.println("Already Data Exist!!!!");
			System.out.println("*************************************");
			response.put("message", 999999);

		} else {
			// CustomerDetails customerDetails = new CustomerDetails();
			// customerService.addCustomerDetails(customerDetailsPojo);
			response.put("message", customerService.addCustomerDetails(customerDetailsPojo));
		}

		return response;
	}

	@PostMapping("/addcustomeraddress")
	public void addCustomerAddress(@RequestBody CustomerAddressPojo customerAddressPojo) {
		customerService.addCustomerAddress(customerAddressPojo);
	}

	@PostMapping("/addcustomeroccupation")
	public void addCustomerOccupation(@RequestBody CustomerOccupationPojo customerOccupationPojo) {
		customerService.addCustomerOccupation(customerOccupationPojo);
	}

	@PostMapping("/addcustomernominee")
	public void addCustomerNominee(@RequestBody CustomerNomineePojo customerNomineePojo) {
		customerService.addCustomerNominee(customerNomineePojo);
	}

	// update part
	@PostMapping("/updatecustomerdetails")
	public void updateDetails(@RequestBody CustomerDetailsPojo customerDetailsPojo) {
		customerService.updateCustomerDetails(customerDetailsPojo);
	}

	@PostMapping("/updatecustomeraddress")
	public void updateAddress(@RequestBody CustomerAddressPojo customerAddressPojo) {
		customerService.updateCustomerAddress(customerAddressPojo);
	}

	@PostMapping("/updatecustomeroccupation")
	public void updateOccupation(@RequestBody CustomerOccupationPojo customerOccupationPojo) {
		customerService.updateCustomerOccupation(customerOccupationPojo);
	}

	@PostMapping("/updatecustomernominee")
	public void updateNominee(@RequestBody CustomerNomineePojo customerNomineePojo) {
		customerService.updateCustomerNominee(customerNomineePojo);
	}

	@PostMapping("/saveAccountDetails")
	public @ResponseBody String saveAccountDetails(@RequestBody AccountDetails account)
	{
		return customerService.saveCustomerAccountDetails(account);
	}
	
	@GetMapping("/getlookupdata")
	public @ResponseBody Map<String, List<AccountLookup>> getLookupDetails()
	{
		return customerService.fetchAllAccountLookupDetails();
	}

}
