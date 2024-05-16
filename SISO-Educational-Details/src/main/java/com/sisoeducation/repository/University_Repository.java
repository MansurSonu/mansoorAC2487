package com.sisoeducation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.UniverisityDetails;

@Repository
public interface University_Repository extends JpaRepository<UniverisityDetails, Integer>{
	

	
 }
