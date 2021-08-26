package com.jocata.customermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.customermanagement.entity.AccountLookup;
import com.jocata.customermanagement.entity.CustomerAccountDetails;
import com.jocata.customermanagement.entity.CustomerAddress;
import com.jocata.customermanagement.entity.CustomerDetails;
import com.jocata.customermanagement.entity.CustomerNominee;
import com.jocata.customermanagement.entity.CustomerOccupation;
import com.jocata.customermanagement.entity.FetchCustomerDetailsEntity;
import com.jocata.customermanagement.entity.LoginEntity;
import com.jocata.customermanagement.model.AccountDetails;
import com.jocata.customermanagement.model.CustomerAddressPojo;
import com.jocata.customermanagement.model.CustomerData;
import com.jocata.customermanagement.model.CustomerDetailsPojo;
import com.jocata.customermanagement.model.CustomerNomineePojo;
import com.jocata.customermanagement.model.CustomerOccupationPojo;
import com.jocata.customermanagement.model.FetchCustomerDetails;
import com.jocata.customermanagement.model.Login;
import com.jocata.customermanagement.repository.AccountLookupRepository;
import com.jocata.customermanagement.repository.CustomerAccountRepository;
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

		List<CustomerAccountDetails> ca = customerAccountRepository.findAll();
		Map<Integer, CustomerAccountDetails> caMap = ca.stream()
				.collect(Collectors.toMap(CustomerAccountDetails::getCustId, e -> e));

		// customerRepository.findAllById()

		for (FetchCustomerDetailsEntity entity : ce) {
			FetchCustomerDetails customerDetails = new FetchCustomerDetails();
			customerDetails.setCifNumber(entity.getCifNumber());
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
			CustomerAccountDetails custAcctDetails = caMap.get(entity.getCustomerId());
			if (custAcctDetails != null)
				customerDetails.setAccountNumber(custAcctDetails.getAccountNumber());
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
	@Autowired
	public CustomerAccountRepository customerAccountRepository;
	@Autowired
	public AccountLookupRepository accountLookupRepository;

	CustomerDetails customerDetails = new CustomerDetails();
	CustomerAddress customerAddress = new CustomerAddress();
	CustomerOccupation customerOccupation = new CustomerOccupation();
	CustomerNominee customerNominee = new CustomerNominee();

	public boolean aadharExists(CustomerDetailsPojo customer) {
		Optional<CustomerDetails> record = customerDetailsRepository.findByaadharNumber(customer.getAadharNumber());
		// Optional<CustomerDetails> record =
		// customerDetailsRepository.findByPanNumber(customer.customerDetailsPojo.getCustomerPan());
		return record.isPresent();
	}

	public int addCustomerDetails(CustomerDetailsPojo customerDetailsPojo) {

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCifNumber(getCifNumber());
		customerDetails.setFirstName(customerDetailsPojo.getFirstName());
		customerDetails.setLastName(customerDetailsPojo.getLastName());
		customerDetails.setDateOfBirth(customerDetailsPojo.getDateOfBirth());
		customerDetails.setGender(customerDetailsPojo.getGender());
		customerDetails.setEmailId(customerDetailsPojo.getEmailId());
		customerDetails.setMaritalStatus(customerDetailsPojo.getMaritalStatus());
		customerDetails.setFatherName(customerDetailsPojo.getFatherName());
		customerDetails.setMotherName(customerDetailsPojo.getMotherName());
		customerDetails.setAadharNumber(customerDetailsPojo.getAadharNumber());
		customerDetails.setPanNumber(customerDetailsPojo.getPanNumber());
		customerDetails.setCustomerMobileNumber(customerDetailsPojo.getCustomerMobileNumber());

		customerDetailsRepository.save(customerDetails);

		return customerDetailsRepository.findByAadharNumber(customerDetailsPojo.getAadharNumber()).getCustomerId();
	}

	public void updateCustomerDetails(CustomerDetailsPojo customerDetailsPojo) {
		CustomerDetails customerDetails = new CustomerDetails();
		CustomerDetails customerDetails1 = customerDetailsRepository
				.findByPanNumber(customerDetailsPojo.getPanNumber());

		if (Objects.isNull(customerDetails1)) {
			customerDetails.setCifNumber(customerDetailsPojo.getCifNumber());
			customerDetails.setFirstName(customerDetailsPojo.getFirstName());
			customerDetails.setLastName(customerDetailsPojo.getLastName());
			customerDetails.setDateOfBirth(customerDetailsPojo.getDateOfBirth());
			customerDetails.setGender(customerDetailsPojo.getGender());
			customerDetails.setEmailId(customerDetailsPojo.getEmailId());
			customerDetails.setMaritalStatus(customerDetailsPojo.getMaritalStatus());
			customerDetails.setFatherName(customerDetailsPojo.getFatherName());
			customerDetails.setMotherName(customerDetailsPojo.getMotherName());
			customerDetails.setAadharNumber(customerDetailsPojo.getAadharNumber());
			customerDetails.setPanNumber(customerDetailsPojo.getPanNumber());
			customerDetails.setCustomerMobileNumber(customerDetailsPojo.getCustomerMobileNumber());

			customerDetailsRepository.save(customerDetails);
		} else {
			customerDetails1.setCifNumber(customerDetailsPojo.getCifNumber());
			customerDetails1.setFirstName(customerDetailsPojo.getFirstName());
			customerDetails1.setLastName(customerDetailsPojo.getLastName());
			customerDetails1.setDateOfBirth(customerDetailsPojo.getDateOfBirth());
			customerDetails1.setGender(customerDetailsPojo.getGender());
			customerDetails1.setEmailId(customerDetailsPojo.getEmailId());
			customerDetails1.setMaritalStatus(customerDetailsPojo.getMaritalStatus());
			customerDetails1.setFatherName(customerDetailsPojo.getFatherName());
			customerDetails1.setMotherName(customerDetailsPojo.getMotherName());
			customerDetails1.setAadharNumber(customerDetailsPojo.getAadharNumber());
			customerDetails1.setPanNumber(customerDetailsPojo.getPanNumber());
			customerDetails1.setCustomerMobileNumber(customerDetailsPojo.getCustomerMobileNumber());

			customerDetailsRepository.save(customerDetails1);
		}
	}

	public void addCustomerAddress(CustomerAddressPojo customerAddressPojo) {

		CustomerAddress customerAddress = new CustomerAddress();

		customerAddress.setCustId(customerAddressPojo.getCustId());
		customerAddress.setCustomerCountry(customerAddressPojo.getCustomerCountry());
		customerAddress.setCustomerState(customerAddressPojo.getCustomerState());
		customerAddress.setCustomerPinCode(customerAddressPojo.getCustomerPinCode());
		customerAddress.setPermanentAddress(customerAddressPojo.getPermanentAddress());
		customerAddress.setCurrentAddress(customerAddressPojo.getCurrentAddress());

		customerAddressRepository.save(customerAddress);
	}

	public void updateCustomerAddress(CustomerAddressPojo customerAddressPojo) {

		CustomerAddress customerAddress1 = customerAddressRepository.findByCustId(customerAddressPojo.getCustId());

		if (Objects.isNull(customerAddress1)) {
			CustomerAddress customerAddress = new CustomerAddress();

			customerAddress.setCustId(customerAddressPojo.getCustId());
			// customerAddress.setAadharNumber(customerAddressPojo.getAadharNumber());
			customerAddress.setCustomerCountry(customerAddressPojo.getCustomerCountry());
			customerAddress.setCustomerState(customerAddressPojo.getCustomerState());
			customerAddress.setCustomerPinCode(customerAddressPojo.getCustomerPinCode());
			customerAddress.setPermanentAddress(customerAddressPojo.getPermanentAddress());
			customerAddress.setCurrentAddress(customerAddressPojo.getCurrentAddress());

			customerAddressRepository.save(customerAddress);
		} else {
			customerAddress1.setCustId(customerAddressPojo.getCustId());
			// customerAddress1.setAadharNumber(customerAddressPojo.getAadharNumber());
			customerAddress1.setCustomerCountry(customerAddressPojo.getCustomerCountry());
			customerAddress1.setCustomerState(customerAddressPojo.getCustomerState());
			customerAddress1.setCustomerPinCode(customerAddressPojo.getCustomerPinCode());
			customerAddress1.setPermanentAddress(customerAddressPojo.getPermanentAddress());
			customerAddress1.setCurrentAddress(customerAddressPojo.getCurrentAddress());

			customerAddressRepository.save(customerAddress1);
		}
	}

	public void addCustomerOccupation(CustomerOccupationPojo customerOccupationPojo) {
		CustomerOccupation customerOccupation = new CustomerOccupation();

		customerOccupation.setCustId(customerOccupationPojo.getCustId());
		customerOccupation.setEmployeeId(customerOccupationPojo.getEmployeeId());
		// customerOccupation.setEmploymentNature(customerOccupationPojo.getEmploymentNature());
		customerOccupation.setCompanyName(customerOccupationPojo.getCompanyName());
		customerOccupation.setDesignation(customerOccupationPojo.getDesignation());
		customerOccupation.setExperience(customerOccupationPojo.getExperience());
		customerOccupation.setAddress(customerOccupationPojo.getAddress());
		customerOccupation.setState(customerOccupationPojo.getState());
		customerOccupation.setCountry(customerOccupationPojo.getCountry());
		customerOccupation.setPinCode(customerOccupationPojo.getPinCode());

		customerOccupationRepository.save(customerOccupation);

	}

	public void updateCustomerOccupation(CustomerOccupationPojo customerOccupationPojo) {
		CustomerOccupation customerOccupation1 = customerOccupationRepository
				.findByCustId(customerOccupationPojo.getCustId());

		if (Objects.isNull(customerOccupation1)) {
			CustomerOccupation customerOccupation = new CustomerOccupation();

			customerOccupation.setCustId(customerOccupationPojo.getCustId());
			customerOccupation.setEmployeeId(customerOccupationPojo.getEmployeeId());
			// customerOccupation.setEmploymentNature(customerOccupationPojo.getEmploymentNature());
			customerOccupation.setCompanyName(customerOccupationPojo.getCompanyName());
			customerOccupation.setDesignation(customerOccupationPojo.getDesignation());
			customerOccupation.setExperience(customerOccupationPojo.getExperience());
			customerOccupation.setAddress(customerOccupationPojo.getAddress());
			customerOccupation.setState(customerOccupationPojo.getState());
			customerOccupation.setCountry(customerOccupationPojo.getCountry());
			customerOccupation.setPinCode(customerOccupationPojo.getPinCode());

			customerOccupationRepository.save(customerOccupation);
		} else {
			customerOccupation1.setCustId(customerOccupationPojo.getCustId());
			customerOccupation1.setEmployeeId(customerOccupationPojo.getEmployeeId());
			// customerOccupation1.setEmploymentNature(customerOccupationPojo.getEmploymentNature());
			customerOccupation1.setCompanyName(customerOccupationPojo.getCompanyName());
			customerOccupation1.setDesignation(customerOccupationPojo.getDesignation());
			customerOccupation1.setExperience(customerOccupationPojo.getExperience());
			customerOccupation1.setAddress(customerOccupationPojo.getAddress());
			customerOccupation1.setState(customerOccupationPojo.getState());
			customerOccupation1.setCountry(customerOccupationPojo.getCountry());
			customerOccupation1.setPinCode(customerOccupationPojo.getPinCode());

			customerOccupationRepository.save(customerOccupation1);
		}

	}

	public void addCustomerNominee(CustomerNomineePojo customerNomineePojo) {
		CustomerNominee customerNominee = new CustomerNominee();

		customerNominee.setCustId(customerNomineePojo.getCustId());
		customerNominee.setNomineeName(customerNomineePojo.getNomineeName());
		customerNominee.setRelationship(customerNomineePojo.getRelationship());
		customerNominee.setMobileNumber(customerNomineePojo.getMobileNumber());

		customerNomineeRepository.save(customerNominee);
	}

	public void updateCustomerNominee(CustomerNomineePojo customerNomineePojo) {
		CustomerNominee customerNominee1 = customerNomineeRepository.findByCustId(customerNomineePojo.getCustId());

		if (Objects.isNull(customerNominee1)) {

			CustomerNominee customerNominee = new CustomerNominee();
			customerNominee.setCustId(customerNomineePojo.getCustId());
			customerNominee.setNomineeName(customerNomineePojo.getNomineeName());
			customerNominee.setRelationship(customerNomineePojo.getRelationship());
			customerNominee.setMobileNumber(customerNomineePojo.getMobileNumber());

			customerNomineeRepository.save(customerNominee);
		} else {
			customerNominee1.setCustId(customerNomineePojo.getCustId());
			customerNominee1.setNomineeName(customerNomineePojo.getNomineeName());
			customerNominee1.setRelationship(customerNomineePojo.getRelationship());
			customerNominee1.setMobileNumber(customerNomineePojo.getMobileNumber());

			customerNomineeRepository.save(customerNominee1);
		}
	}

	/*
	 * public void addCustomer(CustomerData customerPojo) {
	 * 
	 * // Personal Details //
	 * customerDetails.setCustomerId(customerPojo.getCustomerId());
	 * customerDetails.setAccountNumber(getAccountNumber());
	 * customerDetails.setFirstName(customerPojo.getFirstName());
	 * customerDetails.setLastName(customerPojo.getLastName());
	 * customerDetails.setDateOfBirth(customerPojo.getDateOfBirth());
	 * customerDetails.setGender(customerPojo.getGender());
	 * customerDetails.setEmailId(customerPojo.getEmailId());
	 * customerDetails.setMartialStatus(customerPojo.getMartialStatus());
	 * customerDetails.setFatherName(customerPojo.getFatherName());
	 * customerDetails.setMotherName(customerPojo.getMotherName());
	 * customerDetails.setAadharNumber(customerPojo.getAadharNumber());
	 * customerDetails.setPanNumber(customerPojo.getPanNumber());
	 * customerDetails.setCustomerMobileNumber(customerPojo.getMobileNumber());
	 * 
	 * // Customer Address //
	 * customerAddress.setCustomerId(customerPojo.getCustomerId());
	 * customerAddress.setCustomerCountry(customerPojo.getCustomerCountry());
	 * customerAddress.setCustomerState(customerPojo.getCustomerState());
	 * customerAddress.setCustomerPinCode(customerPojo.getCustomerPinCode());
	 * customerAddress.setPermanentAddress(customerPojo.getPermanentAddress());
	 * customerAddress.setCurrentAddress(customerPojo.getCurrentAddress());
	 * customerAddress.setAadharNumber(customerPojo.getAadharNumber()); // Customer
	 * Occupation // customerOccupation.setCustomerId(customerPojo.getCustomerId());
	 * customerOccupation.setEmployeeId(customerPojo.getEmployeeId());
	 * customerOccupation.setCompanyName(customerPojo.getCompanyName());
	 * customerOccupation.setDesignation(customerPojo.getDesignation());
	 * customerOccupation.setExperience(customerPojo.getExperience());
	 * customerOccupation.setAddress(customerPojo.getAddress());
	 * customerOccupation.setState(customerPojo.getState());
	 * customerOccupation.setCountry(customerPojo.getCountry());
	 * customerOccupation.setPinCode(customerPojo.getPincode());
	 * customerOccupation.setAadharNumber(customerPojo.getAadharNumber());
	 * 
	 * // Customer Nominee //
	 * customerNominee.setCustomerId(customerPojo.getCustomerId());
	 * customerNominee.setNomineeName(customerPojo.getNomineeName());
	 * customerNominee.setRelationship(customerPojo.getRelationship());
	 * customerNominee.setMobileNumber(customerPojo.getMobileNumber());
	 * customerNominee.setAadharNumber(customerPojo.getAadharNumber());
	 * 
	 * customerDetailsRepository.save(customerDetails);
	 * customerAddressRepository.save(customerAddress);
	 * customerOccupationRepository.save(customerOccupation);
	 * customerNomineeRepository.save(customerNominee);
	 * 
	 * }
	 */
	private Integer getCifNumber() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		return Integer.parseInt(String.format("%06d", number));
	}

	public CustomerData getAllCustomerDetails(Integer custId) {

		CustomerData custData = new CustomerData();
		//List<AccountLookup> accLookup = new AccountLookup();
		List<AccountLookup> accLookup = accountLookupRepository.findAll();

        Map<Integer,AccountLookup> lookupData = accLookup.stream().collect(Collectors.toMap(AccountLookup::getLookupId, e -> e));
		try {

			System.out.println(custId);
			CustomerDetails cd = customerDetailsRepository.findByCustomerId(custId);
			CustomerAddress ca = customerAddressRepository.findByCustId(custId);
			CustomerNominee cn = customerNomineeRepository.findByCustId(custId);
			CustomerOccupation co = customerOccupationRepository.findByCustId(custId);
			CustomerAccountDetails cacc = customerAccountRepository.findByCustId(custId);

			// personalDetails
			custData.setCustomerId(cd.getCustomerId());
			custData.setCifNumber(cd.getCifNumber());
			custData.setFirstName(cd.getFirstName());
			custData.setLastName(cd.getLastName());
			custData.setDateOfBirth(cd.getDateOfBirth());
			custData.setGender(cd.getGender());
			custData.setEmailId(cd.getEmailId());
			custData.setAadharNumber(cd.getAadharNumber());
			custData.setPanNumber(cd.getPanNumber());
			custData.setCustomerMobileNumber(cd.getCustomerMobileNumber());
			custData.setFatherName(cd.getFatherName());
			custData.setMotherName(cd.getMotherName());
			custData.setMaritalStatus(cd.getMaritalStatus());

			// address

			custData.setCustomerCountry(ca.getCustomerCountry());
			custData.setCustomerState(ca.getCustomerState());
			custData.setCustomerPinCode(ca.getCustomerPinCode());
			custData.setPermanentAddress(ca.getPermanentAddress());
			custData.setCurrentAddress(ca.getCurrentAddress());

			// nominee

			custData.setNomineeName(cn.getNomineeName());
			custData.setRelationship(cn.getRelationship());
			custData.setMobileNumber(cn.getMobileNumber());

			// occupation

			custData.setEmployeeId(co.getEmployeeId());
			// custData.setEmploymentNature(co.getEmployementNature());
			custData.setCompanyName(co.getCompanyName());
			custData.setDesignation(co.getDesignation());
			custData.setExperience(co.getExperience());
			custData.setAddress(co.getAddress());
			custData.setState(co.getState());
			custData.setCountry(co.getCountry());
			custData.setPinCode(co.getPinCode());
			
			
			//account details
			
			custData.setAccountStatus(lookupData.get(cacc.getAccountStatus()).getLookupValue());
			custData.setBranch(lookupData.get(cacc.getBranch()).getLookupValue());
			custData.setRiskLevel(lookupData.get(cacc.getRiskLevel()).getLookupValue());
			custData.setProductType(lookupData.get(cacc.getProductType()).getLookupValue());
			custData.setAccountNumber(cacc.getAccountNumber());
			custData.setAccountBalance(cacc.getAccountBalance());
			custData.setAccountTurnOver(cacc.getAccountTurnOver());
			custData.setCashTurnOver(cacc.getCashTurnOver());
			custData.setPurposeOfAccount(cacc.getPurposeOfAccount());
			

			
			

		} catch (Exception e) {
			System.out.println("no adhar found");
		}

		return custData;
	}

	// @Autowired
	// public CustomerAccountDetails customerAccountEntity;

	public String saveCustomerAccountDetails(AccountDetails account) {

		CustomerAccountDetails customerAccountEntity = new CustomerAccountDetails();

		customerAccountEntity.setAccountBalance(account.getAccountBalance());
		customerAccountEntity.setAccountNumber(generateAccountNumber());
		customerAccountEntity.setAccountStatus(account.getAccountStatus());
		customerAccountEntity.setBranch(account.getBranch());
		customerAccountEntity.setCashTurnOver(account.getCashTurnOver());
		customerAccountEntity.setProductType(account.getProductType());
		customerAccountEntity.setPurposeOfAccount(account.getPurposeOfAccount());
		customerAccountEntity.setCustId(account.getCustId());
		// customerAccountEntity.setLookupId(account.getLookupId());
		customerAccountEntity.setRiskLevel(account.getRiskLevel());
		customerAccountEntity.setAccountTurnOver(account.getAccountTurnOver());

		customerAccountRepository.save(customerAccountEntity);
		// customerAccountRepository.save(customerAccountEntity);

		return "success fully inserted";
	}

	public Map<String, List<AccountLookup>> fetchAllAccountLookupDetails() {

		List<AccountLookup> lookupData = accountLookupRepository.findAll();

		Map<String, List<AccountLookup>> data = lookupData.stream()
				.collect(Collectors.groupingBy(AccountLookup::getLookupType));
		return data;
	}

	public long generateAccountNumber() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		return random.nextLong(10_000_000_000L, 100_000_000_000L);
	}

}
