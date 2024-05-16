package com.ac.sourceio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac.sourceio.Entity.AddressEntity;
import com.ac.sourceio.Entity.EmployeeEntity;
@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Long> {
	

}
