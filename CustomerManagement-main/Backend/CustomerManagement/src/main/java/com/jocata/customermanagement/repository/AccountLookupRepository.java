package com.jocata.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.AccountLookup;

@Repository
public interface AccountLookupRepository extends JpaRepository<AccountLookup, Integer> {

}
