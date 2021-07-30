package com.jocata.customermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.customermanagement.entity.CustomerAddress;
import com.jocata.customermanagement.entity.CustomerDetails;
import com.jocata.customermanagement.entity.CustomerNominee;
import com.jocata.customermanagement.entity.CustomerOccupation;
import com.jocata.customermanagement.entity.FetchCustomerDetailsEntity;
import com.jocata.customermanagement.entity.LoginEntity;
import com.jocata.customermanagement.model.CustomerData;
import com.jocata.customermanagement.model.FetchCustomerDetails;
import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.repository.CustomerAddressRepository;
import com.jocata.customermanagement.repository.CustomerDetailsRepository;
import com.jocata.customermanagement.repository.CustomerNomineeRepository;
import com.jocata.customermanagement.repository.CustomerOccupationRepository;
import com.jocata.customermanagement.repository.FetchCustomerDetailsRepository;
import com.jocata.customermanagement.repository.LoginRepository;

@Service
public class CustomerService {

	@Autowired
	public LoginEntity loginEntity;

	@Autowired
	public LoginRepository loginRepository;

	public String checkLoginCredentials(Login login) throws Exception {

		int flag = 0;
		String passwordFromDb = null;

		String userNameFromUi = login.getUserName();
		String passWordFromUi = login.getPassWord();

		try {
			LoginEntity row = loginRepository.findByUserName(userNameFromUi);
			passwordFromDb = row.getPassWord();
		} catch (Exception e) {
			return "Not found";
		}

		if (passWordFromUi.equals(passwordFromDb))
			flag = 1;

		if (flag == 1)
			return "success";

		else
			return "invalid password";

	}

	@Autowired
	public FetchCustomerDetailsRepository customerRepository;

	public List<FetchCustomerDetails> getAllCustomersDetails() {
		List<FetchCustomerDetails> outputList = new ArrayList<FetchCustomerDetails>();

		// CustomerEntity ce = customerRepository.findCustomerEntities();
		List<FetchCustomerDetailsEntity> ce = customerRepository.findAll();

		// customerRepository.findAllById()

		for (FetchCustomerDetailsEntity entity : ce) {
			FetchCustomerDetails customerDetails = new FetchCustomerDetails();
			customerDetails.setAccountNumber(entity.getAccountNumber());
			customerDetails.setCustomerId(entity.getCustomerId());
			customerDetails.setFirstName(entity.getFirstName());
			customerDetails.setLastName(entity.getLastName());
			customerDetails.setGender(entity.getGender());
			customerDetails.setDateOfBirth(entity.getDate_of_birth().toString());
			customerDetails.setAadharNumber(entity.getAadharNumber());
			customerDetails.setPanNumber(entity.getPanNumber());
			customerDetails.setMobileNumber(entity.getMobileNumber());
			customerDetails.setEmailId(entity.getEmailId());
			customerDetails.setAccountCreatationDate(entity.getAccountCreationDate().toString());
			customerDetails.setAccountStatus("active");
			customerDetails.setFatherName(entity.getFatherName());
			customerDetails.setMotherName(entity.getMotherName());
			customerDetails.setMartialStatus(entity.getMartialStatus());
			outputList.add(customerDetails);
			// System.out.println(entity.getFirstName());
		}
		return outputList;

	}

	@Autowired
	public CustomerDetailsRepository customerDetailsRepository;
	@Autowired
	public CustomerAddressRepository customerAddressRepository;
	@Autowired
	public CustomerOccupationRepository customerOccupationRepository;
	@Autowired
	public CustomerNomineeRepository customerNomineeRepository;

	CustomerDetails customerDetails = new CustomerDetails();
	CustomerAddress customerAddress = new CustomerAddress();
	CustomerOccupation customerOccupation = new CustomerOccupation();
	CustomerNominee customerNominee = new CustomerNominee();

	public boolean aadharExists(CustomerData customer) {
		Optional<CustomerDetails> record = customerDetailsRepository.findByaadharNumber(customer.getAadharNumber());
		// Optional<CustomerDetails> record =
		// customerDetailsRepository.findByPanNumber(customer.customerDetailsPojo.getCustomerPan());
		return record.isPresent();
	}

	public void addCustomer(CustomerData customerPojo) {

		// Personal Details
		// customerDetails.setCustomerId(customerPojo.getCustomerId());
		customerDetails.setAccountNumber(getAccountNumber());
		customerDetails.setFirstName(customerPojo.getFirstName());
		customerDetails.setLastName(customerPojo.getLastName());
		customerDetails.setDateOfBirth(customerPojo.getDateOfBirth());
		customerDetails.setGender(customerPojo.getGender());
		customerDetails.setEmailId(customerPojo.getEmailId());
		customerDetails.setMartialStatus(customerPojo.getMartialStatus());
		customerDetails.setFatherName(customerPojo.getFatherName());
		customerDetails.setMotherName(customerPojo.getMotherName());
		customerDetails.setAadharNumber(customerPojo.getAadharNumber());
		customerDetails.setPanNumber(customerPojo.getPanNumber());
		customerDetails.setCustomerMobileNumber(customerPojo.getMobileNumber());

		// Customer Address
		// customerAddress.setCustomerId(customerPojo.getCustomerId());
		customerAddress.setCustomerCountry(customerPojo.getCustomerCountry());
		customerAddress.setCustomerState(customerPojo.getCustomerState());
		customerAddress.setCustomerPinCode(customerPojo.getCustomerPinCode());
		customerAddress.setPermanentAddress(customerPojo.getPermanentAddress());
		customerAddress.setCurrentAddress(customerPojo.getCurrentAddress());
		customerAddress.setAadharNumber(customerPojo.getAadharNumber());
		// Customer Occupation
		// customerOccupation.setCustomerId(customerPojo.getCustomerId());
		customerOccupation.setEmployeeId(customerPojo.getEmployeeId());
		customerOccupation.setCompanyName(customerPojo.getCompanyName());
		customerOccupation.setDesignation(customerPojo.getDesignation());
		customerOccupation.setExperience(customerPojo.getExperience());
		customerOccupation.setAddress(customerPojo.getAddress());
		customerOccupation.setState(customerPojo.getState());
		customerOccupation.setCountry(customerPojo.getCountry());
		customerOccupation.setPinCode(customerPojo.getPincode());
		customerOccupation.setAadharNumber(customerPojo.getAadharNumber());

		// Customer Nominee
		// customerNominee.setCustomerId(customerPojo.getCustomerId());
		customerNominee.setNomineeName(customerPojo.getNomineeName());
		customerNominee.setRelationship(customerPojo.getRelationship());
		customerNominee.setMobileNumber(customerPojo.getMobileNumber());
		customerNominee.setAadharNumber(customerPojo.getAadharNumber());

		customerDetailsRepository.save(customerDetails);
		customerAddressRepository.save(customerAddress);
		customerOccupationRepository.save(customerOccupation);
		customerNomineeRepository.save(customerNominee);

	}

	private Integer getAccountNumber() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		return Integer.parseInt(String.format("%06d", number));
	}

}
