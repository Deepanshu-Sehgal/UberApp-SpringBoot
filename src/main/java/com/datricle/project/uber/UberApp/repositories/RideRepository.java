package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {
}
