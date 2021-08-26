package com.jocata.customermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerOccupation;

@Repository
public interface CustomerOccupationRepository extends JpaRepository<CustomerOccupation, Integer> {

	public CustomerOccupation findByCustId(int custid);
}
