package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.Rider;
import com.datricle.project.uber.UberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByUser(User user);
}
