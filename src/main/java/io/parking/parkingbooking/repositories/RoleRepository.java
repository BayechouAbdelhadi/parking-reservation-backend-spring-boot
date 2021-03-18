package io.parking.parkingbooking.repositories;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.parking.parkingbooking.domain.ERole;
import io.parking.parkingbooking.domain.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}