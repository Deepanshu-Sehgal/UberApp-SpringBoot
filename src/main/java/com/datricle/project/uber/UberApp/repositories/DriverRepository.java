package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

}
