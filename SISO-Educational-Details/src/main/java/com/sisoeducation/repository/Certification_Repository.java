package com.sisoeducation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.CertificationsDetails;

@Repository
public interface Certification_Repository extends JpaRepository<CertificationsDetails, Integer>{

	
  	Optional<CertificationsDetails> findByCertId(Integer id);
	
  }
