package com.jocata.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.CustomerOccupation;

@Repository
public interface CustomerOccupationRepository extends JpaRepository<CustomerOccupation, Integer> {
}
