package com.sisoeducation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.CollegeDetails;

@Repository
public interface College_Repository  extends JpaRepository<CollegeDetails, Integer>{

	
	Optional<CollegeDetails> findByClgId(Integer id);


  }
