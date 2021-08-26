package com.jocata.customermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerNominee;

@Repository
public interface CustomerNomineeRepository extends JpaRepository<CustomerNominee, Integer> {


	public CustomerNominee findByCustId(int custid);
}
