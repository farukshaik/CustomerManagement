package com.jocata.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerAccountDetails;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccountDetails, Integer> {

	public CustomerAccountDetails findByCustId(int custId);

	public List<CustomerAccountDetails> findAll();

}
