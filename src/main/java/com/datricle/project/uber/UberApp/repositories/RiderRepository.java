package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Long> {
}
