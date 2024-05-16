package com.sisoeducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisoeducation.pojo.AddEmploymentEntity;

@Repository
public interface AddEmploymentRepo extends JpaRepository<AddEmploymentEntity, Long> {

}
