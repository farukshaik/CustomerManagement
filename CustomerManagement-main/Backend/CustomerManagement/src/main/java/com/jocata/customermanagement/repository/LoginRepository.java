package com.jocata.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jocata.customermanagement.entity.LoginEntity;


@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, String> {

	LoginEntity findByUserName(String userNameFromUi);
	
}
