package com.sarahhospital.patientservice.repository;

import com.sarahhospital.patientservice.entity.HumanNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanNamesRepository extends JpaRepository<HumanNameEntity, Long> {

    List<HumanNameEntity> findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
}
