package io.parking.parkingbooking.services;


import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.parking.parkingbooking.domain.ERole;
import io.parking.parkingbooking.domain.Role;
import io.parking.parkingbooking.domain.User;
import io.parking.parkingbooking.dto.UserRegistrationDto;
import io.parking.parkingbooking.exceptions.RoleException;
import io.parking.parkingbooking.exceptions.UsernameAlreadyExistsException;
import io.parking.parkingbooking.repositories.RoleRepository;
import io.parking.parkingbooking.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (UserRegistrationDto newUser){
       try{
			User user =new User ();
			user.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
			user.setUsername(newUser.getUsername());
			user.setFullName(newUser.getFullName());
            // Make sure that password and confirmPassword match
            // We don't persist or show the confirmPassword
            newUser.setConfirmPassword("");
    		Set<Role> roles=new HashSet<Role>();
    		Set<String> strRoles = new HashSet<String>(Arrays.asList(newUser.getRoles().split(",")));

    		if (strRoles.isEmpty()) 
    		{
    			Role studentRole = roleRepository.findByName(ERole.ROLE_USER)
    					.orElseThrow(() -> new RoleException("Error: Role  Student 1 is not found."));
    			roles.add(studentRole);
    		} else {
    			strRoles.forEach(role -> {
    				switch (role) {
    				case "admin":
    					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
    							.orElseThrow(() -> new RoleException("Error: Role  admin is not found."));
    					roles.add(adminRole);

    					break;
    				case "moderator":
    					Role profRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
    							.orElseThrow(() -> new RoleException("Error: Role prof is not found."));
    					roles.add(profRole);

    					break;
    				case "user":
    					Role studentRole = roleRepository.findByName(ERole.ROLE_USER)
    							.orElseThrow(() -> new RoleException("Error: Role  student 2 is not found."));
    					roles.add(studentRole);

    					break;
    				default:{
    					Role studentRole3 = roleRepository.findByName(ERole.ROLE_USER)
    							.orElseThrow(() -> new RoleException("Error: Role student 3 is not found."));
    					roles.add(studentRole3);
    					
    					}
    					break;
    					
    				}
    			});
    		}
    		user.setRoles(roles);
            return userRepository.save(user);
       }
        catch (RoleException e){
            throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
        }
    }



}
