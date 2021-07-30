package com.jocata.customermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerDetails;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {

	public List<CustomerDetails> findAll();

	Optional<CustomerDetails> findByaadharNumber(String customerAadhar);
	// Optional<CustomerDetails> findByPanNumber(String customerPan);

}
