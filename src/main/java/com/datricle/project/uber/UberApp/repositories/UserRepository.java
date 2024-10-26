package com.datricle.project.uber.UberApp.repositories;

import com.datricle.project.uber.UberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
