package com.ac.sourceio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac.sourceio.Entity.AddEmployementEntity;

@Repository
public interface AddEmployementRepo extends JpaRepository<AddEmployementEntity, Long> {

}
