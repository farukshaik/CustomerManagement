package com.jocata.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerNominee;

@Repository
public interface CustomerNomineeRepository extends JpaRepository<CustomerNominee, Integer> {
	
	public CustomerNominee findByCustId(Integer custId);
}
