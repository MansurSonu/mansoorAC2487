package com.ac.sourceio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac.sourceio.Entity.EducationQualificationsEntity;

@Repository
public interface EducationQualificationsRepo extends JpaRepository<EducationQualificationsEntity, Long> {

}