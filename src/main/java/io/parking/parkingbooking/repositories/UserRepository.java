package io.parking.parkingbooking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.parking.parkingbooking.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);
}
