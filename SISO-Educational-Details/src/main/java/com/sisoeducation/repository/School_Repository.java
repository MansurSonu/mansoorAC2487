package com.sisoeducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.SchoolDetails;

@Repository
public interface School_Repository extends JpaRepository<SchoolDetails, Integer> {

	
  }
