package com.jocata.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.FetchCustomerDetailsEntity;

@Repository
public interface FetchCustomerDetailsRepository extends JpaRepository<FetchCustomerDetailsEntity, Integer> {
	public List<FetchCustomerDetailsEntity> findAll();

	// public List<FetchCustomerDetailsEntity> findByAadharNumber(String aadhar);

}
