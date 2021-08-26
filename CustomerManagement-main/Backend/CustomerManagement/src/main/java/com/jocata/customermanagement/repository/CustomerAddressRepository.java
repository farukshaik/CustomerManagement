package com.jocata.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

	public List<CustomerAddress> findAll();
	//public CustomerAddress findByAadharNumber(String aadharNumber);
	
	public CustomerAddress findByCustId(Integer custId);
}

