package com.sisoeducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisoeducation.pojo.EmployerEntity;

public interface EmployerRepository extends JpaRepository<EmployerEntity, String> {

}
