package com.jocata.customermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerAddress;
import com.jocata.customermanagement.entity.CustomerDetails;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

	public List<CustomerAddress> findAll();

	public CustomerAddress findByCustId(int custid);
}
